package day05.solutions.crane;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import day05.solutions.crane.command.Command;

/**
 * Represents the control console for the Crate Mover (TM) line of Cranes
 *
 */
public interface CrateMoverConsole {

    default Matcher parse(final String input) {
        Pattern pattern = Pattern.compile("move (?<qty>\\d+) from (?<from>\\d+) to (?<to>\\d+)");
        return pattern.matcher(input);
    }
    
    /**
     * Programs the crane to perform an operation
     */
    Command program(String commandText);
}
