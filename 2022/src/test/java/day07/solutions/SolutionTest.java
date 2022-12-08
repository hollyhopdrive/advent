package day07.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import day07.solutions.filesystem.operations.DirectoryDeleter;
import day07.solutions.filesystem.operations.DirectorySizeAggregator;

public class SolutionTest {

    @Test
    public void testPuzzle1Sample() {
        assertEquals(95437, Runner.run("day07/sample.txt", new DirectorySizeAggregator(100000)));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals(1315285, Runner.run("day07/input.txt", new DirectorySizeAggregator(100000)));
    }
    
    @Test
    public void testPuzzle2Sample() {
        assertEquals(24933642, Runner.run("day07/sample.txt", new DirectoryDeleter(30000000)));
    }
    
    @Test
    public void testPuzzle2Real() {
        assertEquals(9847279, Runner.run("day07/input.txt", new DirectoryDeleter(30000000)));
    }
}
