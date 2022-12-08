package day06.solutions;

import day06.solutions.buffer.SignalDetector;

public class Runner {

    public static int run(final String input, final int signalLength) {
        return new SignalDetector(signalLength).process(input);
    }
}
