package day11.solutions.monkeymodulo;

import java.util.HashMap;
import java.util.Map;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Item {

    // The initial value, required for initializing the modulo trackers
    private final int initialWorry;
    
    // An Item has a modulo tracker for each monkey in the network
    private final Map<Integer, ModuloTracker> moduloTrackers = new HashMap<>();
    
    public void addMonkeyModuloTracker(final int denominator) {
        moduloTrackers.put(denominator, new ModuloTracker(denominator, initialWorry % denominator));
    }
    
    /** 
     * Add a value and recalculate the modulos
     */
    public void add(final int amount) {
        moduloTrackers.values().forEach(mt -> mt.add(amount));
    }
    
    /**
     * Square the modulo values
     */
    public void square() {
        moduloTrackers.values().forEach(mt -> mt.square());
    }
    
    /**
     * Apply multiplication and recalculate the modulos
     */
    public void multiply(final int multiplier) {
        moduloTrackers.values().forEach(mt -> mt.multiply(multiplier));
    }
    
    public int getModulo(final int denominator) {
        return moduloTrackers.get(denominator).getModulo();
    }
}
