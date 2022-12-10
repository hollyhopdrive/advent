package day10.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    
    @Test
    public void testPuzzle1Sample() {
        assertEquals(13140, Runner.runSignalStrength("day10/sample.txt"));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals(11220, Runner.runSignalStrength("day10/input.txt"));
    }
    
    @Test
    public void testPuzzle2Sample() {
        
        final String expected 
                = "##..##..##..##..##..##..##..##..##..##..\n"
                + "###...###...###...###...###...###...###.\n"
                + "####....####....####....####....####....\n"
                + "#####.....#####.....#####.....#####.....\n"
                + "######......######......######......####\n"
                + "#######.......#######.......#######.....\n";
        
        assertEquals(expected, Runner.runCrt("day10/sample.txt"));
    }
    
    @Test
    public void testPuzzle2Real() {
        Runner.runCrt("day10/input.txt");
    }
}
