package day09.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void testPuzzle1Sample() {
        assertEquals(13, Runner.run("day09/sample.txt", 2));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals(5513, Runner.run("day09/input.txt", 2));
    }
    
    @Test
    public void testPuzzle2Sample() {
        assertEquals(36, Runner.run("day09/sample2.txt", 10));
    }
    
    @Test
    public void testPuzzle2Real() {
        assertEquals(2427, Runner.run("day09/input.txt", 10));
    }
}
