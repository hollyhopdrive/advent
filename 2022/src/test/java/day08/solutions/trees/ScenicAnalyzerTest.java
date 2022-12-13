package day08.solutions.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import shared.Grid;
import shared.InputReader;

public class ScenicAnalyzerTest {

    @Test
    public void testScenicScores() {
        Grid grid = Grid.create(new InputReader().readInputFile("day08/sample.txt"));
        ScenicAnalyzer analyzer = createTestSubject(grid);
        
        assertEquals(1, analyzer.scenicScore(1, 1));
        assertEquals(4, analyzer.scenicScore(1, 2));
        assertEquals(1, analyzer.scenicScore(1, 3));
        
        assertEquals(6, analyzer.scenicScore(2, 1));
        assertEquals(1, analyzer.scenicScore(2, 2));
        assertEquals(2, analyzer.scenicScore(2, 3));
        
        assertEquals(1, analyzer.scenicScore(3, 1));
        assertEquals(8, analyzer.scenicScore(3, 2));
        assertEquals(3, analyzer.scenicScore(3, 3));
        
    }
    
    private ScenicAnalyzer createTestSubject(final Grid grid) {
        return new ScenicAnalyzer(grid);
    }
}
