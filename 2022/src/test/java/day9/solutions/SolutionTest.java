package day9.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void testPuzzle1Sample() {
        assertEquals(0, Runner.run("day9/sample.txt"));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals(0, Runner.run("day9/input.txt"));
    }
    
    @Test
    public void testPuzzle2Sample() {
        assertEquals(0, Runner.run("day9/sample.txt"));
    }
    
    @Test
    public void testPuzzle2Real() {
        assertEquals(0, Runner.run("day9/input.txt"));
    }
}
