package shared;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CoordinateMath {

    public static int minX(final List<Coordinate> coordinates) {
        return coordinates.stream().map(c -> c.getX()).collect(Collectors.minBy(Integer::compare)).get();
    }
    
    public static int maxX(final List<Coordinate> coordinates) {
        return coordinates.stream().map(c -> c.getX()).collect(Collectors.maxBy(Integer::compare)).get();
    }
    
    public static int minY(final List<Coordinate> coordinates) {
        return coordinates.stream().map(c -> c.getY()).collect(Collectors.minBy(Integer::compare)).get();
    }
    
    public static int maxY(final List<Coordinate> coordinates) {
        return coordinates.stream().map(c -> c.getY()).collect(Collectors.maxBy(Integer::compare)).get();
    }
    
    public static int minXList(final List<List<Coordinate>> coordinates) {
        return coordinates.stream().map(l -> minX(l)).collect(Collectors.minBy(Integer::compare)).get();
    }
    
    public static int maxXList(final List<List<Coordinate>> coordinates) {
        return coordinates.stream().map(l -> maxX(l)).collect(Collectors.maxBy(Integer::compare)).get();
    }
    
    public static int minYList(final List<List<Coordinate>> coordinates) {
        return coordinates.stream().map(l -> minY(l)).collect(Collectors.minBy(Integer::compare)).get();
    }
    
    public static int maxYList(final List<List<Coordinate>> coordinates) {
        return coordinates.stream().map(l -> maxY(l)).collect(Collectors.maxBy(Integer::compare)).get();
    }
    
    /**
     * Get the 'manhatten' distance between c1 and c2
     */
    public static int distance(final Coordinate c1, final Coordinate c2) {
        return Math.abs(c1.getX() - c2.getX()) + Math.abs(c1.getY() - c2.getY()); 
    }
    
    /**
     * Find all coordinates that are exactly the specified Manhatten distance away from c
     */
    public static Set<Coordinate> findAllAtDistance(final Coordinate c, final int distance) {
        Set<Coordinate> coordinates = new HashSet<Coordinate>();
        
        for(Direction d : Direction.values()) {
            
            for(int i = distance, j = 0; i >= 0; i--, j++) {
                switch(d) {
                    case L: coordinates.add(new Coordinate(c.getX() - i, c.getY() + j)); break;
                    case R: coordinates.add(new Coordinate(c.getX() + i, c.getY() + j)); break;
                    case U: coordinates.add(new Coordinate(c.getX() - j, c.getY() - i)); break;
                    case D: coordinates.add(new Coordinate(c.getX() + j, c.getY() - i)); break;
                }
            }
        }
        
        return coordinates;
    }
}
