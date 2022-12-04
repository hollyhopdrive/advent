package day5.solutions;

import java.util.List;

import shared.Counter;
import shared.InputReader;

public class Runner {

    public static int run(final String path) {
        final List<String> input = new InputReader().readInputFile(path);
        final Counter answer = new Counter();
        input.forEach(l -> answer.increment());
        return answer.getValue();
    }
}
