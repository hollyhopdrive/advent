package day3.solutions;

import day3.packing.BadgePrioritizationAction;

public class Puzzle2 {

    public static void main(String[] args) {

        int answer = Runner.run(args[0], new BadgePrioritizationAction());
        System.out.println(answer);
    }
}
