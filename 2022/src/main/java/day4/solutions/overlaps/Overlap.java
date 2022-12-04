package day4.solutions.overlaps;

import java.util.Arrays;
import java.util.stream.Collectors;

public interface Overlap {

    boolean overlaps(String lhs, String rhs);

    default Integer[] splitRange(String assignment) {
        return Arrays.stream(assignment.split("-")).map(Integer::parseInt).collect(Collectors.toList())
                .toArray(new Integer[2]);
    }
}
