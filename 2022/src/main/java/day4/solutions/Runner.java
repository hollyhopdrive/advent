package day4.solutions;

import java.util.List;

import day4.solutions.overlaps.Overlap;
import shared.Counter;
import shared.InputReader;

public class Runner {

    public static int run(final String path, final Overlap overlap) {
        final List<String> input = new InputReader().readInputFile(path);
        final Counter overlaps = new Counter();
        input.forEach(l -> { if(processPair(l, overlap)) { overlaps.increment(); } });
        return overlaps.getValue();
    }

    private static boolean processPair(final String pair, final Overlap overlap) {
        String[] assignments = pair.split(",");
        return overlap.overlaps(assignments[0], assignments[1]);
    }
}
