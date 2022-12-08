package day05.solutions.supplies;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class SuppliesInitializerTest {

    @Test
    public void testPatternMatchSingle() {
        
        List<Stack<Crate>> stacks = new ArrayList<>();
        stacks.add(new Stack<Crate>());
        SuppliesInitializer.parseCrateLine(stacks, "[A]");
        
        assertEquals("A", stacks.get(0).pop().getId());
    }
    
    @Test
    public void testPatternMatchMultiWithSpace() {
        
        List<Stack<Crate>> stacks = new ArrayList<>();
        stacks.add(new Stack<Crate>());
        stacks.add(new Stack<Crate>());
        stacks.add(new Stack<Crate>());
        stacks.add(new Stack<Crate>());
        
        SuppliesInitializer.parseCrateLine(stacks, "[Z] [A]     [F]");
        
        assertEquals("Z", stacks.get(0).pop().getId());
        assertEquals("A", stacks.get(1).pop().getId());
        assertTrue(stacks.get(2).isEmpty());
        assertEquals("F", stacks.get(3).pop().getId());
    }
    
    @Test
    public void testPatternMatchMultiWithMultiSpace() {
        
        List<Stack<Crate>> stacks = new ArrayList<>();
        stacks.add(new Stack<Crate>());
        stacks.add(new Stack<Crate>());
        stacks.add(new Stack<Crate>());
        stacks.add(new Stack<Crate>());
        
        SuppliesInitializer.parseCrateLine(stacks, "[Z]         [F]");
        
        assertEquals("Z", stacks.get(0).pop().getId());
        assertTrue(stacks.get(1).isEmpty());
        assertTrue(stacks.get(2).isEmpty());
        assertEquals("F", stacks.get(3).pop().getId());
    }
    
    @Test
    public void testPatternMatchMultiWithStartSpace() {
        
        List<Stack<Crate>> stacks = new ArrayList<>();
        stacks.add(new Stack<Crate>());
        stacks.add(new Stack<Crate>());
        stacks.add(new Stack<Crate>());
        stacks.add(new Stack<Crate>());
        
        SuppliesInitializer.parseCrateLine(stacks, "    [Z] [A] [F]");
        
        assertTrue(stacks.get(0).isEmpty());
        assertEquals("Z", stacks.get(1).pop().getId());
        assertEquals("A", stacks.get(2).pop().getId());
        assertEquals("F", stacks.get(3).pop().getId());
    }
    
    @Test
    public void testPatternMatchMultiWithEndSpace() {
        
        List<Stack<Crate>> stacks = new ArrayList<>();
        stacks.add(new Stack<Crate>());
        stacks.add(new Stack<Crate>());
        stacks.add(new Stack<Crate>());
        stacks.add(new Stack<Crate>());
        
        SuppliesInitializer.parseCrateLine(stacks, "[Z] [A] [F]    ");
        
        assertEquals("Z", stacks.get(0).pop().getId());
        assertEquals("A", stacks.get(1).pop().getId());
        assertEquals("F", stacks.get(2).pop().getId());
        assertTrue(stacks.get(3).isEmpty());
        
    }
}
