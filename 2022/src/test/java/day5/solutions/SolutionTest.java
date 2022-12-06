package day5.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import day5.solutions.crane.CrateMover9000Console;
import day5.solutions.crane.CrateMover9001Console;

public class SolutionTest {

    @Test
    public void testPuzzle1Sample() {
        assertEquals("CMZ", Runner.run("day5/sample.txt", new CrateMover9000Console()));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals("ZBDRNPMVH", Runner.run("day5/input.txt", new CrateMover9000Console()));
    }
    
    @Test
    public void testPuzzle2Sample() {
        assertEquals("MCD", Runner.run("day5/sample.txt", new CrateMover9001Console()));
    }
    
    @Test
    public void testPuzzle2Real() {
        assertEquals("WDLPFNNNB", Runner.run("day5/input.txt", new CrateMover9001Console()));
    }
}
