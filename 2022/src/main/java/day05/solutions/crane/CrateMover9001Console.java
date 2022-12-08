package day05.solutions.crane;

import java.util.regex.Matcher;

import day05.solutions.crane.command.Command;
import day05.solutions.crane.command.MoveStackCommand;

/**
 * The command console for the Crate Mover 9001
 */
public class CrateMover9001Console implements CrateMoverConsole {

    @Override
    public Command program(final String commandText) {
        final Matcher matcher = parse(commandText);
        if(matcher.matches()) {
            int qty = Integer.parseInt(matcher.group("qty"));
            int from = Integer.parseInt(matcher.group("from"));
            int to = Integer.parseInt(matcher.group("to"));
            return new MoveStackCommand(qty, from, to);
        } else {
            throw new IllegalArgumentException("Invalid Command: " + commandText);
        }
    }

}
