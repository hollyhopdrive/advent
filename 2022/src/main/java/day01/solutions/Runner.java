package day01.solutions;

import java.util.List;

import day01.solutions.calories.CalorieAggregator;
import day01.solutions.inputs.NutritionalInfoReader;
import shared.InputReader;

public class Runner {

    public static int run1(String path) {
        final List<String> input = new InputReader().readInputFile(path);

        final NutritionalInfoReader group = new NutritionalInfoReader();
        final CalorieAggregator aggregator = new CalorieAggregator();

        return aggregator.max(aggregator.sum(group.byElf(input)));
    }
    
    public static int run2(String path) {
        final List<String> input = new InputReader().readInputFile(path);

        final NutritionalInfoReader group = new NutritionalInfoReader();
        final CalorieAggregator aggregate = new CalorieAggregator();

        return aggregate.sum(aggregate.max(aggregate.sum(group.byElf(input)), 3));
    }
}
