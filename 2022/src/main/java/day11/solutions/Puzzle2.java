package day11.solutions;

import java.math.BigInteger;

import day11.solutions.monkeybusiness.Formula;
import day11.solutions.monkeybusiness.Formula.Operator;
import day11.solutions.monkeymodulo.Runner;

public class Puzzle2 {

    public static void main(String[] args) {
        BigInteger answer = Runner.run(args[0], new Formula(Operator.MULTIPLY, "1"), 20);
        System.out.println(answer);
    }
}
