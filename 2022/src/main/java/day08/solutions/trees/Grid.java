package day08.solutions.trees;

import java.util.List;
import java.util.stream.IntStream;

import com.google.common.annotations.VisibleForTesting;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Grid {

    @VisibleForTesting
    @Getter(value=AccessLevel.PACKAGE)
    private final char[][] grid;
    
    public static Grid create(final List<String> input) {
        
        // Verify that the grid is square...
        assert input.size() == input.get(0).length();
        
        int size = input.size();
        Grid grid = new Grid(size);
        
        // Populate the grid
        IntStream.range(0, input.size()).forEach(i -> grid.populateRow(i, input.get(i)));
        return grid;
    }
    
    private Grid(int size) {
        grid = new char[size][size];
    }
    
    private void populateRow(final int index, final String row) {
        IntStream.range(0,  row.length()).forEach(i -> grid[index][i] = row.charAt(i));
    }
    
    public int analyze(final GridAnalyzer analyzer) {
        return analyzer.analyze(grid);
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
