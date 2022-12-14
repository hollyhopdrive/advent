package day13.solutions.packets;

import java.util.Comparator;
import java.util.List;

public class ValueComparator implements Comparator<Value> {

    @Override
    public int compare(final Value lhs, final Value rhs) {
        
        // This takes care of two equal values (lists or integers)
        if(lhs.equals(rhs)) {
            return 0;
        }
        
        // Compare two integers
        if(isInteger(lhs) && isInteger(rhs)) {
            return compareIntegers(lhs, rhs);
        }
        
        // Check for one integer
        if(isInteger(lhs) || isInteger(rhs)) {
            return compareMixed(lhs, rhs);
        }

        // Both (unequal) lists
        return compareLists(lhs, rhs);
    }
    
    private int compareIntegers(final Value lhs, final Value rhs) {
        return new IntegerValueComparator().compare((IntegerValue)lhs, (IntegerValue)rhs);
    }
    
    private int compareMixed(final Value lhs, final Value rhs) {
        return isInteger(lhs) ?
            compare(convert(lhs), rhs) :
            compare(lhs, convert(rhs));
    }
    
    private int compareLists(final Value lhs, final Value rhs) {
        
        int lhsSize = listSize(lhs);
        int rhsSize = listSize(rhs);
       
        // Iterate over each element in the lists
        for(int i = 0; i < lhsSize; ++i) {
            
            if(rhsSize == i) {
                return 1;
            }
            
            int diff = compare(listItem(lhs, i), listItem(rhs, i));
            if(diff != 0) {
                return diff;
            }
        }
        
        /**
         *  We iterated over all of the left list and found no diff, which means one of:
         *  
         *  The lists are equal length, in which case they are equal value. 
         *  This seems counter-intuitive initally because the compare method tests for equality,
         *  but that does not take the type conversion from Integer to List into consideration
         *  
         *  OR
         *  
         *  The right hand side list still has more elements, in which case the order is correct
         **/
        return lhsSize == rhsSize ? 0 : -1;
    }
    
    private int listSize(Value v) {
        return ((ListValue)v).size();
    }
    
    private Value listItem(Value v, int index) {
        return ((ListValue)v).get(index);
    }
    
    private boolean isInteger(Value v) {
        return v instanceof IntegerValue;
    }
    
    private Value convert(Value v) {
        return v instanceof IntegerValue ? new ListValue(List.of(v)) : v;
    }
}
