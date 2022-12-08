package day02.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import day02.solutions.rps.CodifiedOutcome;
import day02.solutions.rps.CodifiedPlay;

public class SolutionTest {

    @Test
    public void testPuzzle1Sample() {
        assertEquals(15, Runner.run("day02/sample.txt", new CodifiedPlay()));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals(10310, Runner.run("day02/input.txt", new CodifiedPlay()));
    }
    
    @Test
    public void testPuzzle2Sample() {
        assertEquals(12, Runner.run("day02/sample.txt", new CodifiedOutcome()));
    }
    
    @Test
    public void testPuzzle2Real() {
        assertEquals(14859, Runner.run("day02/input.txt", new CodifiedOutcome()));
    }
}
