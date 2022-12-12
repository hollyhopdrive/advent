package day11.solutions.monkeymodulo;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import day11.solutions.monkeybusiness.Formula;
import shared.InputReader;

public class Runner {

    public static BigInteger run(final String path, final Formula reliefFormula, final Integer rounds) {
        final List<String> chunks = new InputReader().readChunks(path, "\n\n");
        
        final ModuloMonkeyNetwork network = new ModuloMonkeyNetwork();
        chunks.forEach(monkeyConf -> 
            { ModuloMonkey monkey =
                ModuloMonkey.builder()
                    .withNetwork(network)
                    .withConfig(monkeyConf)
                    .withReliefFormula(reliefFormula)
                    .build();
              network.add(monkey);
            });
        
        network.commit();
        
        for(int i = 0; i < rounds; ++i) {
            network.playRound();
        }
        
        List<ModuloMonkey> monkies = network.getMonkies();
        Collections.sort(monkies, new ModuloMonkeyItemsInspectedComparator());
        
        return BigInteger.valueOf(monkies.get(0).getItemsInspected()).multiply(BigInteger.valueOf(monkies.get(1).getItemsInspected()));
    }
}
