package day05.solutions.crane.command;

import java.util.Stack;

import day05.solutions.supplies.Crate;
import day05.solutions.supplies.Supplies;
import lombok.RequiredArgsConstructor;

/**
 * Move a stack of crates from one stack to another
 */
@RequiredArgsConstructor
public class MoveStackCommand implements Command {

    private final int qty;
    private final int from;
    private final int to;
    
    @Override
    public void execute(final Supplies supplies) {
        final Stack<Crate> crates = supplies.lift(qty, from);
        supplies.drop(crates, to);        
    }
}
