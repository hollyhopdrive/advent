package day3.packing;

import java.util.Set;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompartmentAccessor implements ItemProvider {

    private final BackPack backpack;
    private final boolean compartment1;
    
    @Override
    public Set<Character> getItemTypes() {
        return compartment1 ? backpack.getCompartment1() : backpack.getCompartment2(); 
    }
}
