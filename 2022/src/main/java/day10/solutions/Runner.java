package day10.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import day10.solutions.crt.Crt;
import shared.InputReader;

public class Runner {

    private static final List<Integer> MULTIPLIERS = List.of(20, 60, 100, 140, 180, 220);
    
    public static int runSignalStrength(final String path) {

        final List<Integer> signal = buildSignal(path, null);

        // m-2, to adjust for the zero based index, and to look at the value before the operation completed
        return MULTIPLIERS.stream().map(m -> m * signal.get(m-2)).collect(Collectors.summingInt(Integer::intValue));
    }
    
    public static String runCrt(final String path) {
        Crt crt = new Crt();
        buildSignal(path, crt);
        return crt.toString();
    }
    
    private static List<Integer> buildSignal(final String path, final Crt crt) {
        final List<String> input = new InputReader().readInputFile(path);
        List<Integer> signal = new ArrayList<>();
        input.forEach(l -> process(l, signal, crt));
        return signal;
    }
    
    private static void process(final String line, final List<Integer> x, final Crt crt) {
        
        // If this is the first instruction, the signal will always be initialized with strength 1,
        // whether it's a noop or a addx
        x.add(x.isEmpty() ? 1 : x.get(x.size() - 1));
        
        // Draw the crt pixel
        if(crt != null) {
            crt.draw(x.get(x.size() - 1));
        }
        
        // Handle an addx, which pushes us to the next cycle
        if(line.startsWith("addx")) {
            
            // Draw the next cycle pixel
            if(crt != null) {
                crt.draw(x.get(x.size() - 1));
            }
            
            // Complete the addx to end the cycle
            x.add(x.get(x.size() - 1) + Integer.parseInt(line.split(" ")[1]));
        }
     }
}
