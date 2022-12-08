package day05.solutions.crane;

import java.util.regex.Matcher;

import day05.solutions.crane.command.Command;
import day05.solutions.crane.command.CommandSequence;
import day05.solutions.crane.command.MoveCommand;

/**
 * The command console for the Crate Mover 9000
 */
public class CrateMover9000Console implements CrateMoverConsole {

    @Override
    public Command program(String commandText) {

        CommandSequence sequence = new CommandSequence();
        final Matcher matcher = parse(commandText);
        if (matcher.matches()) {
            int qty = Integer.parseInt(matcher.group("qty"));
            int from = Integer.parseInt(matcher.group("from"));
            int to = Integer.parseInt(matcher.group("to"));
            
            for(int i = 0; i < qty; ++i) sequence.add(new MoveCommand(from, to));
            return sequence;
        } else {
            throw new IllegalArgumentException("Invalid Command: " + commandText);
        }
    }
}
