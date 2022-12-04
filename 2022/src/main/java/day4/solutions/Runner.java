package day4.solutions;

import java.util.List;

import day4.solutions.overlaps.Analyzer;
import day4.solutions.overlaps.Overlap;
import shared.Counter;
import shared.InputReader;

public class Runner {

    public static int run(final String path, final Overlap overlapType) {
        final List<String> input = new InputReader().readInputFile(path);
        final Analyzer overlapAnalyzer = new Analyzer(overlapType);
        final Counter overlaps = new Counter();
        input.forEach(l -> { if(processPair(l, overlapAnalyzer)) { overlaps.increment(); } });
        return overlaps.getValue();
    }

    private static boolean processPair(final String pair, final Analyzer overlapAnalyzer) {
        String[] assignments = pair.split(",");
        return overlapAnalyzer.overlaps(assignments[0], assignments[1]);
    }
}
