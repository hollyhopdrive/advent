package day09.solutions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import shared.InputReader;

public class Runner {

    public static int run(final String path) {
        final List<String> input = new InputReader().readInputFile(path);

        final Head head = new Head();
        final Tail tail = new Tail();
        final Set<Coordinate> visited = new HashSet<Coordinate>(); 
        
        input.forEach(l -> process(l, head, tail, visited));
        
        return visited.size();

    }
    
    private static void process(final String line, final Head head, final Tail tail, final Set<Coordinate> visited) {
        String[] move = line.split(" ");
        Direction direction = Direction.valueOf(move[0]);
        int distance = Integer.parseInt(move[1]);
        
        IntStream.range(0, distance).forEach(i -> visited.add(tail.follow(head.move(direction))));
    }
}
