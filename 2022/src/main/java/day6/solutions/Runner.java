package day6.solutions;

import day6.solutions.buffer.SignalDetector;

public class Runner {

    public static int run(final String input, final int signalLength) {
        return new SignalDetector(signalLength).process(input);
    }
}
