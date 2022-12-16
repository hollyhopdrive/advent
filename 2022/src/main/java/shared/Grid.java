package shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Grid implements GridInterface {
    
    private final char[][] grid;
    
    // The grid doesn't have to extend from [0,0]. If there is unused space to the left or top then it can be shrunk by applying offsets to the indexes
    private final int yOffset;
    private final int xOffset;
    
    /**
     * Create a standard grid, with the top left location at (0,0)
     */
    public Grid(int sizeY, int sizeX) {
        this(sizeY, sizeX, 0, 0);
    }
    
    /**
     * Create a grid with a top left location that is offset from (0,0) in one or both planes
     */
    public Grid(int sizeY, int sizeX, int yOffset, int xOffset) {
        System.out.println("Init grid " + sizeX + " x " + sizeY);
        grid = new char[sizeY][sizeX];
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    /**
     * Get the size of Y (the number of rows)
     */
    @Override
    public int getSizeY() {
        return grid.length;
    }
    
    /**
     * Get the size of Y (the number of columns)
     */
    @Override
    public int getSizeX() {
        return grid[0].length;
    }

    /**
     * Get the current value from the location given
     */
    @Override
    public char getValue(final Coordinate coordinate) {
        return getValue(coordinate.getY(), coordinate.getX());
    }
    
    /**
     * Get the current value from the location given
     */
    @Override
    public char getValue(final int y, final int x) {
        return grid[offsetY(y)][offsetX(x)];
    }
    
    /**
     * Set the specified value in the location given
     */
    @Override
    public void setValue(final Coordinate location, final char value) {
        setValue(location.getY(), location.getX(), value);
    }
    
    /**
     * Set the specified value in the location given
     */
    @Override
    public void setValue(final int y, final int x, final char value) {
        grid[offsetY(y)][offsetX(x)] = value;
    }
    
    /**
     * Set the specified value for every location in the grid
     */
    @Override
    public void fill(final char value) {
        for(int y = 0; y < getSizeY(); ++y) {
            Arrays.fill(grid[y], value);
        }
    }
    
    /**
     * Determine if the given coordinate is within the grid boundary
     */
    @Override
    public boolean contains(final Coordinate c) {
        return contains(c.getX(), c.getY());
    }
    
    /**
     * Determine if the given location is within the grid boundary
     */
    @Override
    public boolean contains(final int x, final int y) {
        final int offsetX = offsetX(x);
        final int offsetY = offsetY(y);
        return offsetX >= 0 && offsetX < getSizeX() && offsetY >= 0 && offsetY < getSizeY();
    }
    
    /**
     * Translate (move) a Coordinate by one space in the given direction.
     * Coordinates are immutable, so a new Coordinate is returned that describes the new location.
     * If the new location would be outside the boundaries of the grid, this method returns null.
     */
    @Override
    public Coordinate translate(final Coordinate from, final Direction d) {
        Coordinate c = new Coordinate(from.getX() + d.getXAdjust(), from.getY() + d.getYAdjust());
        if(offsetX(c.getX()) < 0 || 
                offsetX(c.getX()) >= getSizeX() || 
                offsetY(c.getY()) < 0 || 
                offsetY(c.getY()) >= getSizeY()) {
            return null;
        }
        return c;
    }
    
    /**
     * Count how many locations have the specified value
     */
    @Override
    public int count(final char value) {
       
        final Counter counter = new Counter();
        iterateAll((y,x) -> {
            if(grid[y][x] == value) {
                counter.increment();
            }
        });
        return counter.getValue();    
    }
    
    public Set<Coordinate> findInRow(final int y, final char value) {
        
        int offsetY = offsetY(y);
        if(offsetY < 0 || offsetY >= getSizeY()) {
            System.out.println("No row " + y + " in grid");
            return Collections.emptySet();
        }
        char[] rowValues = grid[offsetY];
        
        Set<Coordinate> set = new HashSet<>();
        
        for(int x = 0; x < rowValues.length; ++x) {
            if(rowValues[x] == value) {
                set.add(new Coordinate(xOffset + x, y));
            }
        }
        System.out.println("Locations with no beacon in row 10: " + set);
        return set;
    }
    
    /**
     * Find all the locations that have the specified value
     */
    @Override
    public List<Coordinate> find(final char value) {

        final List<Coordinate> locations = new ArrayList<>();
        iterateAll((y,x) -> {
            if(getValue(y,x) == value) {
                locations.add(new Coordinate(x + xOffset, y + yOffset));
            }
        });
        return locations;
    }
    
    /**
     * Find the first location that matches the value, starting from the top left and working right then down (like a book!)
     */
    @Override
    public Coordinate findFirst(final char value) {

        return iterateAll((y,x) -> {
            if (grid[y][x] == value) {
                return new Coordinate(x + xOffset, y + yOffset);
            }
            return null;
        });
    }
    
    /**
     * Print a pretty picture
     */
    @Override
    public String toString() {
        
        final StringBuilder builder = new StringBuilder();
        iterateAll((y,x) -> { 
            if(y != 0 && x % getSizeX() == 0) {
                builder.append("\n");
            }
            builder.append(grid[y][x]); 
        });
        
        builder.append("\n");
        return builder.toString();
    }
    
    /**
     * Adjust y by y offset
     */
    private int offsetY(final int y) { 
        return y - yOffset;
    }
    
    /**
     * Adjust x by x offset
     */
    private int offsetX(final int x) { 
        return x - xOffset;
    }
    
    @FunctionalInterface
    public interface CoordinateActor {
        void act(int y, int x); 
    }
    
    /**
     * Apply a lambda to each location in the grid
     */
    private void iterateAll(final CoordinateActor a) {
        for(int y = 0; y < getSizeY(); ++y) {
            for(int x = 0; x < getSizeX(); ++x) {
                a.act(y, x);
            }
        }
    }
    
    @FunctionalInterface
    public interface CoordinateProducer {
        Coordinate producer(int y, int x); 
    }
    
    /**
     * Apply a lambda that may produce a Coordinate to each location in the grid
     */
    private Coordinate iterateAll(final CoordinateProducer p) {
        for(int y = 0; y < getSizeY(); ++y) {
            for(int x = 0; x < getSizeX(); ++x) {
                Coordinate c = p.producer(y, x);
                if(c != null) {
                    return c;
                }
            }
        }
        return null;
    }
}
