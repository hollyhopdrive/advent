package day11.solutions.monkeymodulo;

import java.util.ArrayList;
import java.util.List;

public class ModuloMonkeyNetwork {

    // All items that the monkeys are playing with
    private final List<Item> items = new ArrayList<>();
    
    private final List<ModuloMonkey> monkeys = new ArrayList<>();
    
    public void add(final ModuloMonkey monkey) {
        monkeys.add(monkey);
        items.addAll(monkey.getItems());
    }
    
    public void commit() {
        // Set up the modulo trackers, now that we have all monkeys and items
        // Every monkey needs to track it's own modulo for every item
        monkeys.forEach(m -> {
            items.forEach(i -> i.addMonkeyModuloTracker(m.getTestDenominator()));
        });
    }
   
    
    public void playRound() {
        monkeys.forEach(m -> m.play());
    }
    
    public void dispatch(final Item item, final Integer toMonkey) {
        monkeys.get(toMonkey).catchItem(item);
    }
    
    public List<ModuloMonkey> getMonkies() {
        List<ModuloMonkey> copy = new ArrayList<>(monkeys.size());
        copy.addAll(monkeys);
        return copy;
    }
}
