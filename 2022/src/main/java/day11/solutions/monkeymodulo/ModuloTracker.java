package day11.solutions.monkeymodulo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The key to scaling this problem. 
 * We can't track the actual worry value for each item because the values become too huge, but we can track the
 * modulo value of each item for each monkey, and recalculate the modulo (from each monkey's perspective) when any 
 * monkey changes the item worry value.
 *
 */
@AllArgsConstructor
public class ModuloTracker {

    // The denominator - this is the value that the monkey uses in it's test 
    private int denominator;
    
    // An item has a current modulo for each monkey, that depends on it's denominator
    // When the value of the parent number changes, we instead track the change to the modulo value
    @Getter private int modulo;

    /**
     * Add the given amount to the current modulo, then mod again by the denominator to get the actual new modulo value
     */
    public void add(final int amount) {
        modulo = (modulo + amount) % denominator;
    }
    
    /**
     * Squaring the value is just a special case of multiply
     */
    public void square() {
        multiply(modulo);
    }
    
    public void multiply(final int multiplier) {
        modulo = (modulo * multiplier) % denominator;
    }
}
