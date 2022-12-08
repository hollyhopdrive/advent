package day03.packing;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BackPack {

    private final Set<Character> compartment1ItemTypes;

    private final Set<Character> compartment2ItemTypes;
    
    public Set<Character> getCompartment1() {
        return ImmutableSet.copyOf(compartment1ItemTypes);
    }
    
    public Set<Character> getCompartment2() {
        return ImmutableSet.copyOf(compartment2ItemTypes);
    }
}
