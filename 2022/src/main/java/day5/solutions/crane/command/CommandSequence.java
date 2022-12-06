package day5.solutions.crane.command;

import java.util.ArrayList;
import java.util.List;

import day5.solutions.supplies.Supplies;

/**
 * A series of commands that should be executed together in a specific sequence
 *
 */
public class CommandSequence implements Command {

    private final List<Command> sequence = new ArrayList<>();
    
    /**
     * Add a command to the sequence
     */
    public void add(final Command command) {
        sequence.add(command);
    }
    
    /**
     * Execute all commands in the order they were added
     */
    @Override
    public void execute(Supplies supplies) {
        sequence.forEach(c -> c.execute(supplies));
    }
}
