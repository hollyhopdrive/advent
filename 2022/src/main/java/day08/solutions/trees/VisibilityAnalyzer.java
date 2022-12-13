package day08.solutions.trees;

import lombok.RequiredArgsConstructor;
import shared.Coordinate;
import shared.Counter;
import shared.Direction;
import shared.Grid;
import shared.GridAnalyzer;

@RequiredArgsConstructor
public class VisibilityAnalyzer implements GridAnalyzer {

    private final Grid grid;

    public int analyze() {

        Counter visible = new Counter();
        visible.add(outerTrees());

        // Iterate over every inner tree, check for visibility
        for (int y = 1; y < grid.getSizeY() - 1; ++y) {
            for (int x = 1; x < grid.getSizeX() - 1; ++x) {
                if (isVisible(new Coordinate(x, y))) {
                    visible.increment();
                }
            }
        }

        return visible.getValue();
    }

    public int outerTrees() {
        return 4 * grid.getSizeX() - 4;
    }

    public boolean isVisible(final Coordinate location) {
        return isVisible(location, Direction.L) || 
                isVisible(location, Direction.R) || 
                isVisible(location, Direction.U) || 
                isVisible(location, Direction.D);
    }

    private boolean isVisible(final Coordinate location, final Direction d) {
        Coordinate test = grid.translate(location, d);
        while (test != null) {
            if (grid.getValue(test) >= grid.getValue(location)) {
                return false;
            }
            test = grid.translate(test, d);
        }
        return true;
    }
}
