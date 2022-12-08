package day01.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class SolutionTest {

    @Test
    public void testPuzzle1Sample() {
        assertEquals(24000, Runner.run1("day01/sample.txt"));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals(70296, Runner.run1("day01/input.txt"));
    }
    
    @Test
    public void testPuzzle2Sample() {
        assertEquals(45000, Runner.run2("day01/sample.txt"));
    }
    
    @Test
    public void testPuzzle2Real() {
        assertEquals(205381, Runner.run2("day01/input.txt"));
    }
}