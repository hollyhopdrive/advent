package day08.solutions.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import shared.InputReader;

public class ScenicAnalyzerTest {

    @Test
    public void testScenicScores() {
        Grid grid = Grid.create(new InputReader().readInputFile("day08/sample.txt"));
        ScenicAnalyzer analyzer = createTestSubject();
        
        assertEquals(1, analyzer.scenicScore(1, 1, grid.getGrid()));
        assertEquals(4, analyzer.scenicScore(1, 2, grid.getGrid()));
        assertEquals(1, analyzer.scenicScore(1, 3, grid.getGrid()));
        
        assertEquals(6, analyzer.scenicScore(2, 1, grid.getGrid()));
        assertEquals(1, analyzer.scenicScore(2, 2, grid.getGrid()));
        assertEquals(2, analyzer.scenicScore(2, 3, grid.getGrid()));
        
        assertEquals(1, analyzer.scenicScore(3, 1, grid.getGrid()));
        assertEquals(8, analyzer.scenicScore(3, 2, grid.getGrid()));
        assertEquals(3, analyzer.scenicScore(3, 3, grid.getGrid()));
        
    }
    
    private ScenicAnalyzer createTestSubject() {
        return new ScenicAnalyzer();
    }
}
