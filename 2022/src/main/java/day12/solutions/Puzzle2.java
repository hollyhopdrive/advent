package day12.solutions;

import java.util.Set;

public class Puzzle2 {

    public static void main(String[] args) {
        int answer = Runner.run(args[0], Set.of("S", "a"));
      
        System.out.println(answer);
    }
}
