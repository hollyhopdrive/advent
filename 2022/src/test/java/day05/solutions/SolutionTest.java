package day05.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import day05.solutions.crane.CrateMover9000Console;
import day05.solutions.crane.CrateMover9001Console;

public class SolutionTest {

    @Test
    public void testPuzzle1Sample() {
        assertEquals("CMZ", Runner.run("day05/sample.txt", new CrateMover9000Console()));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals("ZBDRNPMVH", Runner.run("day05/input.txt", new CrateMover9000Console()));
    }
    
    @Test
    public void testPuzzle2Sample() {
        assertEquals("MCD", Runner.run("day05/sample.txt", new CrateMover9001Console()));
    }
    
    @Test
    public void testPuzzle2Real() {
        assertEquals("WDLPFNNNB", Runner.run("day05/input.txt", new CrateMover9001Console()));
    }
}
