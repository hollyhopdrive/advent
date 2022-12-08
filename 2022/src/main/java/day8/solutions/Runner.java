package day8.solutions;

import java.util.List;

import day8.solutions.trees.Grid;
import day8.solutions.trees.GridAnalyzer;
import shared.InputReader;

public class Runner {

    public static int run(final String path, final GridAnalyzer analyzer) {
        final List<String> input = new InputReader().readInputFile(path);
        
        final Grid grid = Grid.create(input);
        System.out.println(grid.toString());

        return grid.analyze(analyzer);
    }    
}
