package day11.solutions.monkeymodulo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import day11.solutions.monkeybusiness.Formula;
import day11.solutions.monkeybusiness.Formula.Operator;

public class SolutionTest {

    
    @Test
    public void testPuzzle2Sample() {
        assertEquals(BigInteger.valueOf(2713310158L), Runner.run("day11/sample.txt", new Formula(Operator.MULTIPLY, "1"), 10000));
    }
    
    @Test
    public void testPuzzle2Real() {
        assertEquals(BigInteger.valueOf(25272176808L), Runner.run("day11/input.txt", new Formula(Operator.MULTIPLY, "1"), 10000));
    }
}
