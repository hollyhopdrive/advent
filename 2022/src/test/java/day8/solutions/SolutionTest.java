package day8.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import day8.solutions.trees.ScenicAnalyzer;
import day8.solutions.trees.VisibilityAnalyzer;

public class SolutionTest {

    @Test
    public void testPuzzle1Sample() {
        assertEquals(21, Runner.run("day8/sample.txt", new VisibilityAnalyzer()));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals(1688, Runner.run("day8/input.txt", new VisibilityAnalyzer()));
    }
    
    @Test
    public void testPuzzle2Sample() {
        assertEquals(8, Runner.run("day8/sample.txt", new ScenicAnalyzer()));
    }
    
    @Test
    public void testPuzzle2Real() {
        assertEquals(410400, Runner.run("day8/input.txt", new ScenicAnalyzer()));
    }
}
