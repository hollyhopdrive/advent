package day12.solutions.route;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shared.Coordinate;

@RequiredArgsConstructor
public class Location {

    @Getter
    private final Coordinate coordinate;
    
    
    public List<Location> extendRoutes(final char[][] grid, final Coordinate current, final Coordinate destination) {
        
        List<Location> validSteps = new ArrayList<>(4);
        
        char currentElevation = currentElevation(grid, current);
        
        // Check if we can move left
        if(current.getX() > 0 && isVerticallyAcceptable(currentElevation, leftElevation(grid, current))) {
            System.out.println("Can move left");
            validSteps.add(new Location(new Coordinate(current.getX() - 1, current.getY())));
        }
        
        // Check if we can move right
        if(current.getX() < grid[0].length-1 && isVerticallyAcceptable(currentElevation, rightElevation(grid, current))) {
            System.out.println("Can move right");
            validSteps.add(new Location(new Coordinate(current.getX() + 1, current.getY())));
        }
        
        // Check if we can move up
        if(current.getY() > 0 && isVerticallyAcceptable(currentElevation, upElevation(grid, current))) {
            System.out.println("Can move up");
            validSteps.add(new Location(new Coordinate(current.getX(), current.getY() - 1)));
        }
        
        // Check if we can move down
        if(current.getY() < grid.length - 1 && isVerticallyAcceptable(currentElevation, downElevation(grid, current))) {
            System.out.println("Can move down");
            validSteps.add(new Location(new Coordinate(current.getX(), current.getY() + 1)));
        }
        
        return validSteps;
    }
    
    private char currentElevation(char[][] grid, Coordinate current) {
        return grid[current.getY()][current.getX()];
    }
    
    private char leftElevation(char[][] grid, Coordinate current) {
        return grid[current.getY()][current.getX() - 1];
    }
    
    private char rightElevation(char[][] grid, Coordinate current) {
        return grid[current.getY()][current.getX() + 1];
    }
    
    private char upElevation(char[][] grid, Coordinate current) {
        return grid[current.getY() - 1][current.getX()];
    }
    
    private char downElevation(char[][] grid, Coordinate current) {
        return grid[current.getY() + 1][current.getX()];
    }
    
    private boolean isVerticallyAcceptable(char currentElevation, char testElevation) {
        if(currentElevation == 'S') {
            return testElevation == 'a';
        }
        if(currentElevation == 'z') {
            return true;
        }
        return currentElevation + 1 >= testElevation;
    }
}
