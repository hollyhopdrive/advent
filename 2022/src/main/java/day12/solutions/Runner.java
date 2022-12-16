package day12.solutions;

import java.util.List;
import java.util.Set;

import day12.solutions.route.RouteAnalyzer;
import shared.GridFactory;
import shared.GridInterface;
import shared.InputReader;

public class Runner {

    public static int run(final String path, final Set<String> startPoints) {
        final List<String> input = new InputReader().readInputFile(path);

        GridInterface grid = GridFactory.createFromInput(input);
        return new RouteAnalyzer(grid, startPoints).analyze();
    }
}
