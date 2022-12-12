package day11.solutions.monkeybusiness;

import java.util.Comparator;

public class MonkeyItemsInspectedComparator implements Comparator<Monkey> {

    @Override
    public int compare(Monkey m1, Monkey m2) {
        return m2.getItemsInspected() - m1.getItemsInspected();
    }

}
