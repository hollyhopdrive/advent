package day13.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void testPuzzle1Sample() {
        assertEquals(13, Runner.runPuzzle1("day13/sample.txt"));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals(5720, Runner.runPuzzle1("day13/input.txt"));
    }
    
    @Test
    public void testPuzzle2Sample() {
        assertEquals(140, Runner.runPuzzle2("day13/sample.txt"));
    }
    
    @Test
    public void testPuzzle2Real() {
        assertEquals(23504, Runner.runPuzzle2("day13/input.txt"));
    }
}
