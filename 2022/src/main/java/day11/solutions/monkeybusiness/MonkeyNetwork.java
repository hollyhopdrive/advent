package day11.solutions.monkeybusiness;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MonkeyNetwork {

    private final List<Monkey> monkies = new ArrayList<>();
    
    public void add(final Monkey monkey) {
        monkies.add(monkey);
    }
    
    public void playRound() {
        monkies.forEach(m -> m.play());
    }
    
    public void dispatch(final BigDecimal item, final Integer toMonkey) {
        monkies.get(toMonkey).catchItem(item);
    }
    
    public List<Monkey> getMonkies() {
        List<Monkey> copy = new ArrayList<>(monkies.size());
        copy.addAll(monkies);
        return copy;
    }
}
