package day04.solutions.overlaps;

public class Full implements Overlap {
    
    @Override
    public boolean overlaps(Integer[] lhs, Integer[] rhs) {
        return lhs[0] <= rhs[0] && lhs[1] >= rhs[1];
    }
}
