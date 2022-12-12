package day11.solutions.monkeybusiness;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shared.Counter;

@RequiredArgsConstructor
public class Monkey {

    public static final class Builder {
    
        private MonkeyNetwork network;
        private List<BigDecimal> items;
        private Formula worryFormula;
        private Formula reliefFormula;
        private MonkeyTest test;
        private Integer testTrueMonkey;
        private Integer testFalseMonkey;
        
        public Builder withNetwork(MonkeyNetwork network) {
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
            items = Arrays.stream(itemLine.split(": ")[1].split(", ")).map(i -> new BigDecimal(i)).collect(Collectors.toList());
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
        
        public Monkey build() {
            return new Monkey(network, items, worryFormula, reliefFormula, test, testTrueMonkey, testFalseMonkey);
        }
    };
    
    public static Builder builder() {
        return new Builder();
    }
    
    private final MonkeyNetwork network;
    
    // The items held by this Monkey, or more specifically the amount of worry we have about those items
    @Getter private final List<BigDecimal> items;
    
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
        
        items.forEach(item -> {      
            BigDecimal worry = worryFormula.apply(item);         
            worry = reliefFormula.apply(worry);
       
            boolean testPass = test.apply(worry);
            network.dispatch(worry, testPass ? testTrueMonkey : testFalseMonkey);
        });
        itemsInspected.add(items.size());
        items.clear();
    }
    
    /**
     * An item has been thrown to this monkey. Catch it!
     */
    void catchItem(final BigDecimal item) {
        items.add(item);
    }
    
    public int getItemsInspected() {
        return itemsInspected.getValue();
    }
}
