package day5.solutions.crane.command;

import day5.solutions.supplies.Crate;
import day5.solutions.supplies.Supplies;
import lombok.RequiredArgsConstructor;

/**
 * Move a single crate from one stack to another
 *
 */
@RequiredArgsConstructor
public class MoveCommand implements Command {

    private final int from;
    private final int to;
    
    @Override
    public void execute(final Supplies supplies) {
        Crate crate = supplies.lift(from);
        supplies.drop(crate, to);        
    }
}
