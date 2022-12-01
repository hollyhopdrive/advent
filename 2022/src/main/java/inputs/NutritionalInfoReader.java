package inputs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reads the nutritional information from the food wrappers carried by elves
 *
 */
public class NutritionalInfoReader {

	public Map<Integer, List<Integer>> byElf(List<String> infos) {
		Map<Integer, List<Integer>> caloriesByElf = new HashMap<Integer, List<Integer>>();
		
		// For now, elfs are identified by their position in line, i.e. a number starting at 1
		Counter elfCounter = new Counter(1);
		infos.stream().forEach(i -> {
			if(i.isBlank()) {
				elfCounter.increment();
			} else {
				List<Integer> caloriesForElf = caloriesByElf.getOrDefault(elfCounter.getValue(), new ArrayList<Integer>());
				caloriesForElf.add(Integer.parseInt(i));
				caloriesByElf.putIfAbsent(elfCounter.getValue(), caloriesForElf);
			}
		});
		
		return caloriesByElf;
	}
}
