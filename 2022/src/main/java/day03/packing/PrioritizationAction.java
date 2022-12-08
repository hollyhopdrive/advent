package day03.packing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import shared.Counter;

public abstract class PrioritizationAction implements Action {

    private List<ItemProvider> itemProviders = new ArrayList<>();
    
    protected int addItemProvider(final ItemProvider itemProvider) {
        itemProviders.add(itemProvider);
        return itemProviders.size();
    }
    
    protected Integer perform() {
        Set<Character> commonItems = new HashSet<>();
        commonItems.addAll(itemProviders.get(0).getItemTypes());
        IntStream.range(1, itemProviders.size()).forEach(i -> commonItems.retainAll(itemProviders.get(i).getItemTypes()));
        
        Counter counter = new Counter();
        commonItems.forEach(c -> {
            int offset = Character.isLowerCase(c) ? Priorities.LOWERCASE_PRIORITY_OFFSET : Priorities.UPPERCASE_PRIORITY_OFFSET;
            counter.add((int) c + offset);
        });
        
        itemProviders.clear();
        
        return counter.getValue();
    }
}
