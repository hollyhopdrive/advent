package day08.solutions.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import shared.Coordinate;
import shared.Grid;
import shared.GridFactory;
import shared.InputReader;

public class ScenicAnalyzerTest {

    @Test
    public void testScenicScores() {
        Grid grid = GridFactory.createFromInput(new InputReader().readInputFile("day08/sample.txt"));
        ScenicAnalyzer analyzer = createTestSubject(grid);
        
        assertEquals(1, analyzer.scenicScore(new Coordinate(1, 1)));
        assertEquals(4, analyzer.scenicScore(new Coordinate(2, 1)));
        assertEquals(1, analyzer.scenicScore(new Coordinate(3, 1)));
        
        assertEquals(6, analyzer.scenicScore(new Coordinate(1, 2)));
        assertEquals(1, analyzer.scenicScore(new Coordinate(2, 2)));
        assertEquals(2, analyzer.scenicScore(new Coordinate(3, 2)));
        
        assertEquals(1, analyzer.scenicScore(new Coordinate(1, 3)));
        assertEquals(8, analyzer.scenicScore(new Coordinate(2, 3)));
        assertEquals(3, analyzer.scenicScore(new Coordinate(3, 3)));
        
    }
    
    private ScenicAnalyzer createTestSubject(final Grid grid) {
        return new ScenicAnalyzer(grid);
    }
}
