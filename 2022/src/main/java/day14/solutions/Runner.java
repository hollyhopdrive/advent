package day14.solutions;

import java.util.List;
import java.util.stream.Collectors;

import day14.solutions.rocks.CaveBuilder;
import day14.solutions.rocks.FluidSimulator;
import day14.solutions.rocks.RockStructure;
import shared.Grid;
import shared.InputReader;

public class Runner {

    public static int run(final String path, final boolean withFloor) {
        final List<String> input = new InputReader().readInputFile(path);
        
        final List<RockStructure> structures = input.stream().map(l -> RockStructure.Parser.parse(l)).collect(Collectors.toList());
        
        // The max coordinates are zero based, so the size of the grid is +1 in each direction
        final Grid cave = CaveBuilder.createCave(structures, withFloor);
        
        final FluidSimulator simulator = new FluidSimulator(cave, CaveBuilder.SAND_SOURCE);
        return simulator.analyze();
    }
    /**
    public static int runWithFloor(final String path) {
        final List<String> input = new InputReader().readInputFile(path);
        
        final List<RockStructure> structures = input.stream().map(l -> RockStructure.Parser.parse(l)).collect(Collectors.toList());
        structures.add(buildFloor(structures));
        
        final Grid cave = CaveBuilder.createCave(structures);
        
        final FluidSimulator simulator = new FluidSimulator(cave, CaveBuilder.SAND_SOURCE);
        return simulator.analyze();
    }
    **/
}
