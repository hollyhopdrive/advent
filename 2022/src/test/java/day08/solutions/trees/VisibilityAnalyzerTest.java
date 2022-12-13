package day08.solutions.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import shared.Grid;
import shared.InputReader;

public class VisibilityAnalyzerTest {
    
    @Test
    public void testOuterTreeCount() {
        Grid grid = Grid.create(new InputReader().readInputFile("day08/sample.txt"));
        VisibilityAnalyzer analyzer = createTestSubject(grid);
        assertEquals(16, analyzer.outerTrees());
    }
    
    @Test
    public void testVisibleTrees() {
        Grid grid = Grid.create(new InputReader().readInputFile("day08/sample.txt"));
        VisibilityAnalyzer analyzer = createTestSubject(grid);
        assertTrue(analyzer.isVisible(1, 1));
        assertTrue(analyzer.isVisible(1, 2));
        assertTrue(analyzer.isVisible(2, 1));
        assertTrue(analyzer.isVisible(2, 3));
        assertTrue(analyzer.isVisible(3, 2));
    }
    
    @Test
    public void testInvisibleTrees() {
        Grid grid = Grid.create(new InputReader().readInputFile("day08/sample.txt"));
        VisibilityAnalyzer analyzer = createTestSubject(grid);
        assertFalse(analyzer.isVisible(1, 3));
        assertFalse(analyzer.isVisible(2, 2));
        assertFalse(analyzer.isVisible(3, 1));
        assertFalse(analyzer.isVisible(3, 3));
    }
    
    private VisibilityAnalyzer createTestSubject(final Grid grid) {
        return new VisibilityAnalyzer(grid);
    }
}
