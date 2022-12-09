package day09.solutions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import shared.InputReader;

public class Runner {

    public static int run(final String path, final int knotCount) {
        final List<String> input = new InputReader().readInputFile(path);

        // Build the knot 'snake'
        Tail tail = null;
        for(int i = 0; i < knotCount - 1; ++i) {
            tail = new Tail(tail);
        }
        final Head head = new Head(tail);
        
        // Where' has the tail been?
        final Set<Coordinate> visited = new HashSet<Coordinate>(); 
        
        input.forEach(l -> process(l, head, visited));

        return visited.size();

    }
    
    private static void process(final String line, final Head head, final Set<Coordinate> visited) {
        String[] move = line.split(" ");
        Direction direction = Direction.valueOf(move[0]);
        int distance = Integer.parseInt(move[1]);
        
        IntStream.range(0, distance).forEach(i -> visited.add(head.move(direction)));
    }
}
