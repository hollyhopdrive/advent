package day3.packing;

/**
 * An action that triggers automatically as backpacks are added to it
 *
 */
public interface Action {
    
    /**
     * Process a BackPack, and trigger the action
     */
    Integer process(BackPack backpack);
}
