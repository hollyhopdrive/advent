package day08.solutions.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import shared.InputReader;

public class VisibilityAnalyzerTest {
    
    @Test
    public void testOuterTreeCount() {
        Grid grid = Grid.create(new InputReader().readInputFile("day08/sample.txt"));
        VisibilityAnalyzer analyzer = createTestSubject();
        assertEquals(16, analyzer.outerTrees(grid.getGrid()));
    }
    
    @Test
    public void testVisibleTrees() {
        Grid grid = Grid.create(new InputReader().readInputFile("day08/sample.txt"));
        VisibilityAnalyzer analyzer = createTestSubject();
        assertTrue(analyzer.isVisible(1, 1, grid.getGrid()));
        assertTrue(analyzer.isVisible(1, 2, grid.getGrid()));
        assertTrue(analyzer.isVisible(2, 1, grid.getGrid()));
        assertTrue(analyzer.isVisible(2, 3, grid.getGrid()));
        assertTrue(analyzer.isVisible(3, 2, grid.getGrid()));
    }
    
    @Test
    public void testInvisibleTrees() {
        Grid grid = Grid.create(new InputReader().readInputFile("day08/sample.txt"));
        VisibilityAnalyzer analyzer = createTestSubject();
        assertFalse(analyzer.isVisible(1, 3, grid.getGrid()));
        assertFalse(analyzer.isVisible(2, 2, grid.getGrid()));
        assertFalse(analyzer.isVisible(3, 1, grid.getGrid()));
        assertFalse(analyzer.isVisible(3, 3, grid.getGrid()));
    }
    
    private VisibilityAnalyzer createTestSubject() {
        return new VisibilityAnalyzer();
    }
}
