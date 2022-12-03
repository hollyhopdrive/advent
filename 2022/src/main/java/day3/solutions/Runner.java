package day3.solutions;

import java.util.List;

import day3.packing.Action;
import day3.packing.BackPackInputProcessor;
import shared.Counter;
import shared.InputReader;

public class Runner {

    public static int run(String path, Action action) {
        final List<String> input = new InputReader().readInputFile(path);
        final BackPackInputProcessor backPackInputProcessor = new BackPackInputProcessor();
        Counter counter = new Counter();
        input.forEach(l -> counter.add(action.process(backPackInputProcessor.createBackPack(l))));
        return counter.getValue();
    }
}
