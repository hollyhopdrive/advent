package day1.solutions;

import java.util.List;

import day1.calories.CalorieAggregator;
import day1.inputs.NutritionalInfoReader;
import shared.InputReader;

/**
By the time you calculate the answer to the Elves' question, they've already realized that the Elf carrying the most Calories of food might eventually run out of snacks.

To avoid this unacceptable situation, the Elves would instead like to know the total Calories carried by the top three Elves carrying the most Calories. That way, even if one of those Elves runs out of snacks, they still have two backups.

In the example above, the top three Elves are the fourth Elf (with 24000 Calories), then the third Elf (with 11000 Calories), then the fifth Elf (with 10000 Calories). The sum of the Calories carried by these three elves is 45000.

Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?
*/
public class TopThreeCalorieCarriers {

	public static void main(String args[]) {
		
		final List<String> input = new InputReader().readInputFile(args[0]);
		
		final NutritionalInfoReader group = new NutritionalInfoReader();
		final CalorieAggregator aggregate = new CalorieAggregator();
		
		final int max = aggregate.sum(aggregate.max(aggregate.sum(group.byElf(input)), 3));
		
		System.out.println(max);
	}
}
