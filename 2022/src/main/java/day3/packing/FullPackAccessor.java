package day3.packing;

import java.util.HashSet;
import java.util.Set;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FullPackAccessor implements ItemProvider {

    private final BackPack backpack;
    
    @Override
    public Set<Character> getItemTypes() {
        Set<Character> allItems = new HashSet<>();
        allItems.addAll(backpack.getCompartment1());
        allItems.addAll(backpack.getCompartment2());
        return allItems;
    }
}
