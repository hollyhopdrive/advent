package shared;

import java.util.List;
import java.util.stream.IntStream;

public class GridFactory {

    public static GridInterface createFromInput(final List<String> input) {
        int sizeY = input.size();
        int sizeX = input.get(0).length();
        GridInterface grid = new Grid(sizeY, sizeX);
        
        // Populate the grid
        IntStream.range(0, input.size()).forEach(i -> populateRow(grid, i, input.get(i)));
        return grid;
    }
    
    private static void populateRow(final GridInterface grid, final int index, final String row) {
        IntStream.range(0,  row.length()).forEach(i -> grid.setValue(index, i, row.charAt(i)));
    }
}
