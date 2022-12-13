package day12.solutions.route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.RequiredArgsConstructor;
import shared.Coordinate;
import shared.Direction;
import shared.Grid;
import shared.GridAnalyzer;

@RequiredArgsConstructor
public class RouteAnalyzer implements GridAnalyzer {

    private final Grid grid;
    
    private static final char END = 'E';

    private final Set<String> possibleStartPoints;
    
    // Keep track of where we've been. If a route goes somewhere that another route has already traversed, then
    // that route can be scrapped
    private final Set<Coordinate> traversedLocations = new HashSet<>();
    
    @Override
    public int analyze() {
        List<Integer> routeLengths = new ArrayList<>();
        List<Coordinate> possibleStartCoordinates = new ArrayList<Coordinate>();
        possibleStartPoints.forEach(s -> possibleStartCoordinates.addAll(grid.find(s.charAt(0))));
        
        possibleStartCoordinates.forEach(c -> {
            // Classify all possible start coordinates as traversed. If we hit one, it would be the start of a different route.
            traversedLocations.addAll(possibleStartCoordinates);
            routeLengths.add(analyzeFromStartPoint(c));
            traversedLocations.clear();
        });
        
        Collections.sort(routeLengths);
        return routeLengths.get(0)-1;
    }
    
    private int analyzeFromStartPoint(final Coordinate start) {
        
        Coordinate destination = grid.findFirst(END);
        
        List<List<Coordinate>> routes = new ArrayList<>();
        List<Coordinate> startRoute = new ArrayList<Coordinate>();
        startRoute.add(start);
        routes.add(startRoute);
        
        while(!routes.isEmpty() && routeTo(routes, destination) == null) {
            
            List<List<Coordinate>> toRemove = new ArrayList<>();
            List<List<Coordinate>> toAdd = new ArrayList<>();
            
            // For each route, extend it. This may produce up to 4 new routes
            routes.forEach(r -> {
                toRemove.add(r);
                toAdd.addAll(extendRoute(r));
            });
            
            routes.removeAll(toRemove);
            routes.addAll(toAdd);      
        }
        if(routes.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return routeTo(routes, destination).size();
    }

    public List<List<Coordinate>> extendRoute(final List<Coordinate> route) {

        // We could spin off up to 4 new routes
        List<List<Coordinate>> newRoutes = new ArrayList<>(Direction.values().length);
        
        final Coordinate current = route.get(route.size() - 1);

        // Attempt to extend the route in each direction
        Arrays.stream(Direction.values()).forEach(d -> {
            Coordinate to = grid.translate(current, d);
            if(isLegalRoute(current, to)) {
                List<Coordinate> newRoute = new ArrayList<>(route.size() + 1);
                newRoute.addAll(route);
                newRoute.add(to);
                traversedLocations.add(to);
                newRoutes.add(newRoute);
            }
        });

        return newRoutes;
    }
    
    private boolean isLegalRoute(final Coordinate from, final Coordinate to) {
        
        if(to == null) {
            return false;
        }
        
        if(traversedLocations.contains(to)) {
            return false;
        }
      
        return isVerticallyAcceptable(
                grid.getValue(from),
                grid.getValue(to));
    }
    
    private boolean isVerticallyAcceptable(char currentElevation, char testElevation) {
        if (currentElevation == 'S') {
            return testElevation == 'a';
        } else if (currentElevation == 'z') {
            return true;
        } else if(testElevation == 'E') {
            return false;
        } else {
            return currentElevation + 1 >= testElevation;
        }
    }
    
    private List<Coordinate> routeTo(final List<List<Coordinate>> routes, final Coordinate destination) {
        for(int i = 0; i < routes.size(); ++i) {
            // Could use contains, but we know the destination will always be the last element, if present
            if(routes.get(i).get(routes.get(i).size()-1).equals(destination)) {
                return routes.get(i);
            }
        }
        return null;
    }
}
