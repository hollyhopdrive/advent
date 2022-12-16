package day15.solutions.sensors;

import java.util.Comparator;

public class RunLengthEncodingComparator implements Comparator<RunLengthEncoding>{

    @Override
    public int compare(final RunLengthEncoding lhs, final RunLengthEncoding rhs) {
        if(lhs.equals(rhs)) {
            return 0;
        }
        
        if(lhs.getStart() == rhs.getStart()) {
            return lhs.getEnd() < rhs.getEnd() ? -1 : 1;
        }
        
        return lhs.getStart() < rhs.getStart() ? -1 : 1;
    }
}
