package day5.solutions.supplies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * Create the initial stacks
 *
 */
public class SuppliesInitializer {

    public static Supplies initialize(final List<String> lines) {
        
        final List<Stack<Crate>> stacks = new ArrayList<>();
        
        // First, reverse the order so that we can build stacks from the bottom up.
        Collections.reverse(lines);
        
        // Determine and create the required number of stacks
        int numStacks = parseStacksLine(lines.get(0));
        for(int i = 0; i < numStacks; ++i) {
            stacks.add(new Stack<>());
        }
     
        IntStream.range(1, lines.size()).forEach(i -> 
            parseCrateLine(stacks, lines.get(i)));
        
        return new Supplies(stacks);  
    }
    
    public static int parseStacksLine(final String stacksLine) {
        Pattern pattern = Pattern.compile("(\\s*(?<max>[0-9+])\\s*)*");
        Matcher matcher = pattern.matcher(stacksLine);
        if(matcher.matches()) {
            return Integer.parseInt(matcher.group("max"));
        } else {
            throw new IllegalArgumentException("Invalid stack line " + stacksLine);
        }
    }
    
    public static void parseCrateLine(final List<Stack<Crate>> stacks, final String crateLine) {
        
        Pattern pattern = Pattern.compile("(\\[[A-Z]\\]\\s?|\\s\\s\\s\\s?)");
        Matcher matcher = pattern.matcher(crateLine);
        stacks.forEach(s -> {
            boolean found = matcher.find();
            assert found;
            
            String match = matcher.group();
            if(!match.isBlank()) {
                match = match.stripTrailing().replace("[", "").replace("]", "");
                s.push(new Crate(match));
            }
        });
    }
}
