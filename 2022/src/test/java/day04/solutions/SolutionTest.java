package day04.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import day04.solutions.overlaps.Full;
import day04.solutions.overlaps.Partial;

public class SolutionTest {

    @Test
    public void testPuzzle1Sample() {
        assertEquals(2, Runner.run("day04/sample.txt", new Full()));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals(431, Runner.run("day04/input.txt", new Full()));
    }
    
    @Test
    public void testPuzzle2Sample() {
        assertEquals(4, Runner.run("day04/sample.txt", new Partial()));
    }
    
    @Test
    public void testPuzzle2Real() {
        assertEquals(823, Runner.run("day04/input.txt", new Partial()));
    }
}
