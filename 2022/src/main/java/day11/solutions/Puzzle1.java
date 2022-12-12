package day11.solutions;

import java.math.BigInteger;

import day11.solutions.monkeybusiness.Formula;
import day11.solutions.monkeybusiness.Formula.Operator;
import day11.solutions.monkeybusiness.Runner;

public class Puzzle1 {

    public static void main(String[] args) {
        BigInteger answer = Runner.run(args[0], new Formula(Operator.DIVIDE, "3"), 20);
        System.out.println(answer);
    }
}
