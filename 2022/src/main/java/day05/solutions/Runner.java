package day05.solutions;

import java.util.List;
import java.util.stream.Collectors;

import day05.solutions.crane.CrateMoverConsole;
import day05.solutions.supplies.Supplies;
import day05.solutions.supplies.SuppliesInitializer;
import shared.InputReader;

public class Runner {

    public static String run(final String path, final CrateMoverConsole console) {
        final List<String> input = new InputReader().readInputFile(path);
        input.remove(""); // Junk spacer
        
        final List<String> commands = input.stream().filter(s -> s.startsWith("move")).collect(Collectors.toList());
        input.removeAll(commands); 
        
        Supplies supplies = SuppliesInitializer.initialize(input);
        commands.forEach(c -> console.program(c).execute(supplies));
        
        return supplies.topCrates();
    }
}
