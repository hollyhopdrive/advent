package day01.solutions.inputs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import day01.solutions.inputs.NutritionalInfoReader;

public class NutritionalInfoReaderTest {

	@Test
	public void testReadCaloriesByElf() {
		
		List<String> input = List.of("1000", "2000", "3000", "", "4000", "", "5000", "6000", "", "7000", "8000", "9000", "", "10000");
		
		Map<Integer, List<Integer>> result = createTestSubject().byElf(input);
		
		assertEquals(5, result.size());
		
		assertEquals(result.get(1), List.of(Integer.valueOf(1000), Integer.valueOf(2000), Integer.valueOf(3000)), "Elf 1 calorie count is incorrect");
		assertEquals(result.get(2), List.of(Integer.valueOf(4000)), "Elf 2 calorie count is incorrect");
		assertEquals(result.get(3), List.of(Integer.valueOf(5000), Integer.valueOf(6000)), "Elf 3 calorie count is incorrect");
		assertEquals(result.get(4), List.of(Integer.valueOf(7000), Integer.valueOf(8000), Integer.valueOf(9000)), "Elf 4 calorie count is incorrect");
		assertEquals(result.get(5), List.of(Integer.valueOf(10000)), "Elf 5 calorie count is incorrect");
	}
	
	private NutritionalInfoReader createTestSubject() {
		return new NutritionalInfoReader();
	}	
}
