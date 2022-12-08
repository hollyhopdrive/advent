package day04.solutions.overlaps;

import java.util.Arrays;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Analyzer {

    private final Overlap overlapType;
    
    public boolean overlaps(final String lhs, final String rhs) {
        final Integer[] lhsRange = splitRange(lhs);
        final Integer[] rhsRange = splitRange(rhs);
        return overlapType.overlaps(lhsRange, rhsRange) || overlapType.overlaps(rhsRange, lhsRange);
    }
    
    private Integer[] splitRange(String assignment) {
        return Arrays.stream(assignment.split("-")).map(Integer::parseInt).collect(Collectors.toList())
                .toArray(new Integer[2]);
    }
}
