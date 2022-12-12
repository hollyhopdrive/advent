package day11.solutions.monkeymodulo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import day11.solutions.monkeybusiness.MonkeyTest;
import day11.solutions.monkeybusiness.Formula;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shared.Counter;

@RequiredArgsConstructor
public class ModuloMonkey {

    public static final class Builder {

        private ModuloMonkeyNetwork network;
        private List<Item> items;
        private Formula worryFormula;
        private Formula reliefFormula;
        private MonkeyTest test;
        private Integer testTrueMonkey;
        private Integer testFalseMonkey;

        public Builder withNetwork(ModuloMonkeyNetwork network) {
            this.network = network;
            return this;
        }

        public Builder withConfig(final String config) {
            String[] lines = config.split("\n");
            return withItems(lines[1])
                    .withWorryFormula(lines[2])
                    .withTest(lines[3])
                    .withTestTrueMonkey(lines[4])
                    .withTestFalseMonkey(lines[5]);
        }

        public Builder withItems(final String itemLine) {
            items = Arrays.stream(itemLine.split(": ")[1].split(", ")).map(i -> new Item(Integer.parseInt(i))).collect(Collectors.toList());
            return this;
        }

        public Builder withWorryFormula(final String formulaLine) {
            String[] formula = formulaLine.split("old ")[1].split(" ");
            worryFormula = new Formula(Formula.Operator.fromSymbol(formula[0]), formula[1]);
            return this;
        }

        public Builder withReliefFormula(final Formula reliefFormula) {
            this.reliefFormula = reliefFormula;
            return this;

        }

        public Builder withTest(final String testLine) {
            test = new MonkeyTest(Integer.parseInt(testLine.split(" ")[5]));
            return this;
        }

        public Builder withTestTrueMonkey(final String line) {
            testTrueMonkey = parseTestMonkey(line);
            return this;
        }

        public Builder withTestFalseMonkey(final String line) {
            testFalseMonkey = parseTestMonkey(line);
            return this;
        }

        private Integer parseTestMonkey(final String line) {
            return Integer.parseInt(line.substring(line.length() - 1, line.length()));
        }

        public ModuloMonkey build() {
            return new ModuloMonkey(network, items, worryFormula, reliefFormula, test, testTrueMonkey, testFalseMonkey);
        }
    };

    public static Builder builder() {
        return new Builder();
    }

    private final ModuloMonkeyNetwork network;

    // The items held by this Monkey, or more specifically the amount of worry we have about those items
    @Getter private final List<Item> items;

    // The formulas applied to item worry levels
    private final Formula worryFormula;
    private final Formula reliefFormula;

    // The test applied by the Monkey
    private final MonkeyTest test;

    private final Integer testTrueMonkey;
    private final Integer testFalseMonkey;

    private final Counter itemsInspected = new Counter();

    // It's this Monkey's turn. Play with the items
    public void play() {

        items.forEach(i -> {
            applyInspectionFormula(i);
            applyReliefFormula(i);
            testAndThrow(i);
        });
        
        itemsInspected.add(items.size());
        items.clear();
    }
    
    private void applyInspectionFormula(final Item item) {
        applyFormula(item, worryFormula);
    }
    
    private void applyReliefFormula(final Item item) {
        applyFormula(item, reliefFormula);
    }
    
    private void applyFormula(final Item item, final Formula formula) {
        if(formula.getOperand().equals(Formula.OLD)) {
            item.square();
        } else {
            switch(formula.getOperator()) {
              case ADD: item.add(Integer.parseInt(formula.getOperand())); break;
              case MULTIPLY: item.multiply(Integer.parseInt(formula.getOperand())); break;
              //case DIVIDE: item.divide(Integer.parseInt(formula.getOperand())); break;
              default: throw new RuntimeException("Divide not expected");
            }
        }
    }

    private void testAndThrow(final Item item) {
        network.dispatch(item, item.getModulo(test.getDenominator()) == 0 ? testTrueMonkey : testFalseMonkey);
    }
    
    /**
     * An item has been thrown to this monkey. Catch it!
     */
    void catchItem(final Item item) {
        items.add(item);
    }

    public int getItemsInspected() {
        return itemsInspected.getValue();
    }

    public int getTestDenominator() {
        return test.getDenominator();
    }
}
