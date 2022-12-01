package inputs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class InputReaderTest {

	@Test
	public void testReadSampleInput() {
		InputReader reader = new InputReader();
		List<String> values = reader.readInputFile("CountingCalories/sample.txt");
		
		assertEquals(14, values.size());
		assertEquals(List.of("1000", "2000", "3000", "", "4000", "", "5000", "6000", "", "7000", "8000", "9000", "", "10000"), values);
	}
}
