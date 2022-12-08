package day08.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import day08.solutions.trees.ScenicAnalyzer;
import day08.solutions.trees.VisibilityAnalyzer;

public class SolutionTest {

    @Test
    public void testPuzzle1Sample() {
        assertEquals(21, Runner.run("day08/sample.txt", new VisibilityAnalyzer()));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals(1688, Runner.run("day08/input.txt", new VisibilityAnalyzer()));
    }
    
    @Test
    public void testPuzzle2Sample() {
        assertEquals(8, Runner.run("day08/sample.txt", new ScenicAnalyzer()));
    }
    
    @Test
    public void testPuzzle2Real() {
        assertEquals(410400, Runner.run("day08/input.txt", new ScenicAnalyzer()));
    }
}
