package day13.solutions.packets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class IntegerValueCompareTest {

    @Test
    public void testTwoIntegers() {
        
        IntegerValue lhs = new IntegerValue(6);
        IntegerValue rhs = new IntegerValue(8);
        
        ListValueComparator comparator = new ListValueComparator();
        assertTrue(comparator.compare(lhs, rhs) < 0);
        assertTrue(comparator.compare(rhs, lhs) > 0);
        assertEquals(0, comparator.compare(lhs, lhs));
    }
    
    @Test
    public void testNaturalOrderAscending() {
        
        List<IntegerValue> values = new ArrayList<>();
        values.add(new IntegerValue(8));
        values.add(new IntegerValue(6));
        values.add(new IntegerValue(10));
        
        Collections.sort(values, new ListValueComparator());

        assertEquals(new IntegerValue(6), values.get(0));
        assertEquals(new IntegerValue(8), values.get(1));
        assertEquals(new IntegerValue(10), values.get(2));
    }
    
    @Test
    public void testEqual() {
        ListValueComparator comparator = new ListValueComparator();
        assertEquals(0, comparator.compare(new IntegerValue(8), new IntegerValue(8)));
    }
}
