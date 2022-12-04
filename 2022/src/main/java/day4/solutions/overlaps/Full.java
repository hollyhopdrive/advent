package day4.solutions.overlaps;

public class Full implements Overlap {

    @Override
    public boolean overlaps(final String lhs, final String rhs) {
        final Integer[] lhsRange = splitRange(lhs);
        final Integer[] rhsRange = splitRange(rhs);
        return rangeOverlaps(lhsRange, rhsRange) || rangeOverlaps(rhsRange, lhsRange);
    }
    
    private boolean rangeOverlaps(Integer[] lhs, Integer[] rhs) {
        return lhs[0] <= rhs[0] && lhs[1] >= rhs[1];
    }
}
