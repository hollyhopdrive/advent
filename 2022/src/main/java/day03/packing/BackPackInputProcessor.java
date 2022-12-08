package day03.packing;

import java.util.Set;
import java.util.stream.Collectors;

public class BackPackInputProcessor {

    public BackPack createBackPack(final String items) {
        String compartment1 = items.substring(0, items.length() / 2);
        String compartment2 = items.substring(items.length() / 2, items.length());

        return new BackPack(stringToSet(compartment1), stringToSet(compartment2));
    }
    
    private Set<Character> stringToSet(final String s) {
        return s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    }
}
