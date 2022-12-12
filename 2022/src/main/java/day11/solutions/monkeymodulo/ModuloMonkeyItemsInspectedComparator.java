package day11.solutions.monkeymodulo;

import java.util.Comparator;

public class ModuloMonkeyItemsInspectedComparator implements Comparator<ModuloMonkey> {

    @Override
    public int compare(ModuloMonkey m1, ModuloMonkey m2) {
        return m2.getItemsInspected() - m1.getItemsInspected();
    }

}
