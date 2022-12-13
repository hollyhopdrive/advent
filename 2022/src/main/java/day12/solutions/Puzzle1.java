package day12.solutions;

import java.util.Collections;

public class Puzzle1 {

    public static void main(String[] args) {
        int answer = Runner.run(args[0], Collections.singleton("S"));
        System.out.println(answer);
    }
}
