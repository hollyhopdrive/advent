package day5.solutions.crane.command;

import day5.solutions.supplies.Supplies;

/**
 * A Crane Command, to perform one or more operations
 */
public interface Command {

    /**
     * Execute the command
     */
    void execute(Supplies supplies);
}
