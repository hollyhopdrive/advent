package day08.solutions.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import shared.Coordinate;
import shared.GridFactory;
import shared.GridInterface;
import shared.InputReader;

public class VisibilityAnalyzerTest {
    
    @Test
    public void testOuterTreeCount() {
        GridInterface grid = GridFactory.createFromInput(new InputReader().readInputFile("day08/sample.txt"));
        VisibilityAnalyzer analyzer = createTestSubject(grid);
        assertEquals(16, analyzer.outerTrees());
    }
    
    @Test
    public void testVisibleTrees() {
        GridInterface grid = GridFactory.createFromInput(new InputReader().readInputFile("day08/sample.txt"));
        VisibilityAnalyzer analyzer = createTestSubject(grid);
        assertTrue(analyzer.isVisible(new Coordinate(1, 1)));
        assertTrue(analyzer.isVisible(new Coordinate(1, 2)));
        assertTrue(analyzer.isVisible(new Coordinate(2, 1)));
        assertTrue(analyzer.isVisible(new Coordinate(2, 3)));
        assertTrue(analyzer.isVisible(new Coordinate(3, 2)));
    }
    
    @Test
    public void testInvisibleTrees() {
        GridInterface grid = GridFactory.createFromInput(new InputReader().readInputFile("day08/sample.txt"));
        VisibilityAnalyzer analyzer = createTestSubject(grid);
        assertFalse(analyzer.isVisible(new Coordinate(1, 3)));
        assertFalse(analyzer.isVisible(new Coordinate(2, 2)));
        assertFalse(analyzer.isVisible(new Coordinate(3, 1)));
        assertFalse(analyzer.isVisible(new Coordinate(3, 3)));
    }
    
    private VisibilityAnalyzer createTestSubject(final GridInterface grid) {
        return new VisibilityAnalyzer(grid);
    }
}
