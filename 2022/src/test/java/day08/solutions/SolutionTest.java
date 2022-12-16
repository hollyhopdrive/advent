package day08.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import day08.solutions.trees.ScenicAnalyzer;
import day08.solutions.trees.VisibilityAnalyzer;
import shared.GridAnalyzer;
import shared.GridFactory;
import shared.GridInterface;
import shared.InputReader;

public class SolutionTest {

    @Test
    public void testPuzzle1Sample() {
        
        assertEquals(21, Runner.run(getVisibilityAnalyzer("day08/sample.txt")));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals(1688, Runner.run(getVisibilityAnalyzer("day08/input.txt")));
    }
    
    @Test
    public void testPuzzle2Sample() {
        assertEquals(8, Runner.run(getScenicAnalyzer("day08/sample.txt")));
    }
    
    @Test
    public void testPuzzle2Real() {
        assertEquals(410400, Runner.run(getScenicAnalyzer("day08/input.txt")));
    }
    
    private GridAnalyzer getVisibilityAnalyzer(final String path) {
        return new VisibilityAnalyzer(createGrid(path));
    }
    
    private GridAnalyzer getScenicAnalyzer(final String path) {
        
        return new ScenicAnalyzer(createGrid(path));
    }
    
    private GridInterface createGrid(final String path) {
        final List<String> input = new InputReader().readInputFile(path);
        return GridFactory.createFromInput(input);
    }
}
