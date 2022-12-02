package day1.inputs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import day1.calories.CalorieAggregator;

public class CalorieAggregatorTest {

	@Test
	public void testSumMultiMap() {
	
		Map<Integer, List<Integer>> map = new HashMap<>();
		map.put(1, List.of(1, 4, 8));
		map.put(2, List.of(6, 10, 18));
		
		List<Integer> sums = createTestSubject().sum(map);
		assertEquals(2, sums.size());
		assertTrue(sums.contains(13));
		assertTrue(sums.contains(34));
	}
	
	@Test
	public void testSum() {
		List<Integer> list = List.of(1000, 2000, 8000, 10000, 5000, 9000);
		assertEquals(35000, createTestSubject().sum(list));
	}
	
	@Test
	public void testMax() {
		
		List<Integer> list = List.of(1000, 2000, 8000, 10000, 5000, 9000);
		assertEquals(10000, createTestSubject().max(list));
	}
	
	@Test
	public void testMaxN() {
		
		List<Integer> list = new ArrayList<>();
		list.add(1000);
		list.add(2000);
		list.add(8000);
		list.add(10000);
		list.add(5000);
		list.add(9000);
		
		List<Integer> max3 = createTestSubject().max(list, 3);
		assertEquals(3, max3.size());
		assertEquals(10000, max3.get(0));
		assertEquals(9000, max3.get(1));
		assertEquals(8000, max3.get(2));
	}

	private CalorieAggregator createTestSubject() {
		return new CalorieAggregator();
	}
}
