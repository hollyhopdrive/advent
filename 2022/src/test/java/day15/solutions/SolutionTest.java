package day15.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void testPuzzle1Sample() {
        assertEquals(26, Runner.runPart1("day15/sample.txt", 10));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals(5147333, Runner.runPart1("day15/input.txt", 2000000));
    }
    
    @Test
    public void testPuzzle2Sample() {
        assertEquals(BigInteger.valueOf(56000011), Runner.runPart2("day15/sample.txt", 20));
    }
    
    @Test
    public void testPuzzle2Real() {
        assertEquals(BigInteger.valueOf(13734006908372L), Runner.runPart2("day15/input.txt", 4000000));
    }
}
