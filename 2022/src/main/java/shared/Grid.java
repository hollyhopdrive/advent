package shared;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.google.common.annotations.VisibleForTesting;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Grid {

    @VisibleForTesting
    @Getter
    private final char[][] grid;
    
    public static Grid create(final List<String> input) {
        
        int sizeY = input.size();
        int sizeX = input.get(0).length();
        Grid grid = new Grid(sizeY, sizeX);
        
        // Populate the grid
        IntStream.range(0, input.size()).forEach(i -> grid.populateRow(i, input.get(i)));
        return grid;
    }
    
    private Grid(int sizeY, int sizeX) {
        grid = new char[sizeY][sizeX];
    }
    
    private void populateRow(final int index, final String row) {
        IntStream.range(0,  row.length()).forEach(i -> grid[index][i] = row.charAt(i));
    }
    
    public int getSizeX() {
        return grid[0].length;
    }
    
    public int getSizeY() {
        return grid.length;
    }
    
    public char getValue(final Coordinate coordinate) {
        return getValue(coordinate.getY(), coordinate.getX());
    }
    
    public char getValue(final int y, final int x) {
        return grid[y][x];
    }
    
    public Coordinate translate(final Coordinate from, final Direction d) {
        Coordinate c = new Coordinate(from.getX() + d.getXAdjust(), from.getY() + d.getYAdjust());
        if(c.getX() < 0 || c.getX() >= getSizeX() || c.getY() < 0 || c.getY() >= getSizeY()) {
            return null;
        }
        return c;
    }
    
    public List<Coordinate> find(final char value) {

        List<Coordinate> locations = new ArrayList<>();
        for (int y = 0; y < getSizeY(); ++y) {
            for (int x = 0; x < getSizeX(); ++x) {
                if (getValue(y, x) == value) {
                    locations.add(new Coordinate(x, y));
                }
            }
        }
        return locations;
    }
    
    public Coordinate findFirst(final char value) {
        for (int y = 0; y < getSizeY(); ++y) {
            for (int x = 0; x < getSizeX(); ++x) {
                if (getValue(y, x) == value) {
                    return new Coordinate(x, y);
                }
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int x = 0; x < grid.length; ++x) {
            for(int y = 0; y < grid[x].length; ++y) {
                builder.append((grid[x][y]));
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
