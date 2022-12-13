package day12.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void testPuzzle1Sample() {
        assertEquals(31, Runner.run("day12/sample.txt", Collections.singleton("S")));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals(391, Runner.run("day12/input.txt", Collections.singleton("S")));
    }
    
    @Test
    public void testPuzzle2Sample() {
        assertEquals(29, Runner.run("day12/sample.txt", Set.of("S", "a")));
    }
    
    @Test
    public void testPuzzle2Real() {
        assertEquals(386, Runner.run("day12/input.txt", Set.of("S", "a")));
    }
}
