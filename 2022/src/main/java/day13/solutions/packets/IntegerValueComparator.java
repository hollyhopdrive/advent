package day13.solutions.packets;

import java.util.Comparator;

public class IntegerValueComparator implements Comparator<IntegerValue> {

    @Override
    public int compare(final IntegerValue lhs, final IntegerValue rhs) {
        return lhs.getValue() - rhs.getValue();
    }
}
