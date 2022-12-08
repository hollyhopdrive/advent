package day03.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import day03.solutions.packing.BadgePrioritizationAction;
import day03.solutions.packing.ReorgPrioritizationAction;

public class SolutionTest {

    @Test
    public void testPart1Sample() {
        assertEquals(157, Runner.run("day03/sample.txt", new ReorgPrioritizationAction()));
    }
    
    @Test
    public void testPart1Real() {
        assertEquals(7737, Runner.run("day03/input.txt", new ReorgPrioritizationAction()));
    }
    
    @Test
    public void testPart2Sample() {
        assertEquals(70, Runner.run("day03/sample.txt", new BadgePrioritizationAction()));
    }
    
    @Test
    public void testPart2Real() {
        assertEquals(2697, Runner.run("day03/input.txt", new BadgePrioritizationAction()));
    }
}
