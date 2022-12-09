package day09.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void testPuzzle1Sample() {
        assertEquals(13, Runner.run("day09/sample.txt"));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals(5513, Runner.run("day09/input.txt"));
    }
    
    @Test
    public void testPuzzle2Sample() {
        assertEquals(36, Runner.run("day09/sample.txt"));
    }
    
    @Test
    public void testPuzzle2Real() {
        assertEquals(0, Runner.run("day09/input.txt"));
    }
}
