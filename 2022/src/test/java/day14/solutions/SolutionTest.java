package day14.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void testPuzzle1Sample() {
        assertEquals(24, Runner.run("day14/sample.txt", false));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals(862, Runner.run("day14/input.txt", false));
    }
    
    @Test
    public void testPuzzle2Sample() {
        assertEquals(93, Runner.run("day14/sample.txt", true));
    }
    
    @Test
    public void testPuzzle2Real() {
        assertEquals(28744, Runner.run("day14/input.txt", true));
    }
}
