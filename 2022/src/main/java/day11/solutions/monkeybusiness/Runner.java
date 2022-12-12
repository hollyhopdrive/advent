package day11.solutions.monkeybusiness;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import shared.InputReader;

public class Runner {

    public static BigInteger run(final String path, final Formula reliefFormula, final Integer rounds) {
        final List<String> chunks = new InputReader().readChunks(path, "\n\n");
        
        final MonkeyNetwork network = new MonkeyNetwork();
        chunks.forEach(monkeyConf -> 
            network.add(
                    Monkey.builder()
                    .withNetwork(network)
                    .withConfig(monkeyConf)
                    .withReliefFormula(reliefFormula)
                    .build()));
        
        for(int i = 0; i < rounds; ++i) {
            network.playRound();
        }
        
        List<Monkey> monkies = network.getMonkies();
        Collections.sort(monkies, new MonkeyItemsInspectedComparator());
        
        return BigInteger.valueOf(monkies.get(0).getItemsInspected()).multiply(BigInteger.valueOf(monkies.get(1).getItemsInspected()));
    }
}
