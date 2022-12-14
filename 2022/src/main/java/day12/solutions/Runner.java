package day12.solutions;

import java.util.List;
import java.util.Set;

import day12.solutions.route.RouteAnalyzer;
import shared.Grid;
import shared.GridFactory;
import shared.InputReader;

public class Runner {

    public static int run(final String path, final Set<String> startPoints) {
        final List<String> input = new InputReader().readInputFile(path);

        Grid grid = GridFactory.createFromInput(input);
        return new RouteAnalyzer(grid, startPoints).analyze();
    }
}
