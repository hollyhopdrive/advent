package day4.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import day4.solutions.overlaps.Full;
import day4.solutions.overlaps.Partial;

public class SolutionTest {

    @Test
    public void testPuzzle1Sample() {
        assertEquals(2, Runner.run("day4/sample.txt", new Full()));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals(431, Runner.run("day4/input.txt", new Full()));
    }
    
    @Test
    public void testPuzzle2Sample() {
        assertEquals(4, Runner.run("day4/sample.txt", new Partial()));
    }
    
    @Test
    public void testPuzzle2Real() {
        assertEquals(823, Runner.run("day4/input.txt", new Partial()));
    }
}
