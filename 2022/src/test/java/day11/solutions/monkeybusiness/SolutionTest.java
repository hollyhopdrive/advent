package day11.solutions.monkeybusiness;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import day11.solutions.monkeybusiness.Formula.Operator;

public class SolutionTest {

    @Test
    public void testPuzzle1Sample() {
        assertEquals(BigInteger.valueOf(10605), Runner.run("day11/sample.txt", new Formula(Operator.DIVIDE, "3"), 20));
    }
    
    @Test
    public void testPuzzle1Real() {
        assertEquals(BigInteger.valueOf(112221), Runner.run("day11/input.txt", new Formula(Operator.DIVIDE, "3"), 20));
    }

}
