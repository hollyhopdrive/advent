package day01.calories;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Aggregates calories carried by each Elf
 *
 */
public class CalorieAggregator {

	/**
	 * Sum the values for each key in a multi-map, return a list of the summed values
	 * The order of the list elements is indeterminate
	 */
	public List<Integer> sum(final Map<Integer, List<Integer>> map) {
		return map.values().stream()
				.map(v -> v.stream().collect(Collectors.summingInt(Integer::intValue))).collect(Collectors.toList());
	}
	
	/**
	 * Sum the values in a list of calories
	 */
	public int sum(final List<Integer> list) {
		return list.stream().collect(Collectors.summingInt(Integer::intValue));
	}
	
	/**
	 * Return the max n values from a list of calories
	 */
	public List<Integer> max(List<Integer> list, final int n) {
		Collections.sort(list, Collections.reverseOrder());
		return list.subList(0, n);
	}
	
	/**
	 * Return the max value from a list of calories
	 */
	public int max(final List<Integer> list) {
		final Optional <Integer> max = list.stream().reduce(Integer::max);
		return max.isPresent() ? max.get() : 0;
	}
}
