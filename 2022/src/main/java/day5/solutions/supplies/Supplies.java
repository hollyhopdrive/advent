package day5.solutions.supplies;

import java.util.List;
import java.util.Stack;

import lombok.RequiredArgsConstructor;

/**
 * Stacks of crates. Crates can be moved between stacks.
 */
@RequiredArgsConstructor
public class Supplies {

    private final List<Stack<Crate>> stacks;
    
    /**
     * Lift a crate from the stack identified by the given number
     */
    public Crate lift(final int stack) {
        return stacks.get(stack-1).pop();
    }
    
    /**
     * Lift multiple crates from the stack identified by the given number
     */
    public Stack<Crate> lift(final int quantity, final int stack) {
        Stack<Crate> lifted = new Stack<Crate>();
        while(lifted.size() < quantity) {
            lifted.push(stacks.get(stack-1).pop());
        }
        return lifted;
    }
    
    /**
     * Drop a crate onto a stack
     */
    public void drop(final Crate crate, final int stack) {
        stacks.get(stack-1).push(crate);
    }
    
    /**
     * Drop multiple crates onto a stack
     */
    public void drop(final Stack<Crate> crates, final int stack) {
        while(!crates.isEmpty()) {
            stacks.get(stack-1).push(crates.pop());
        }
    }
    
    public String topCrates() {
        StringBuilder topCrates = new StringBuilder();
        stacks.stream().forEach(s -> topCrates.append(s.peek().getId()));
        return topCrates.toString();
    }
}

