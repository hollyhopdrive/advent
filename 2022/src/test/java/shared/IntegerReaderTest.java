package shared;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class IntegerReaderTest {

    @Test
    public void testReadIntegers() {
        List<Integer> ints = IntegerReader.readAllIntegers("Sensor at x=1326566, y=3575946: closest beacon is at x=1374835, y=2000000");
        assertEquals(4, ints.size());
        assertEquals(1326566, ints.get(0));
        assertEquals(3575946, ints.get(1));
        assertEquals(1374835, ints.get(2));
        assertEquals(2000000, ints.get(3));
    }
    
    @Test
    public void testReadNegativeValues() {
        List<Integer> ints = IntegerReader.readAllIntegers("Sensor at x=2813357, y=5535: closest beacon is at x=3595763, y=-77322");
        assertEquals(4, ints.size());
        assertEquals(2813357, ints.get(0));
        assertEquals(5535, ints.get(1));
        assertEquals(3595763, ints.get(2));
        assertEquals(-77322, ints.get(3));
    }
    
    @Test
    public void testReadCoordinates() {
        List<Coordinate> coordinates = IntegerReader.readCoordinates("Sensor at x=1326566, y=3575946: closest beacon is at x=1374835, y=2000000");
        assertEquals(2, coordinates.size());
        
        assertEquals(new Coordinate(1326566, 3575946), coordinates.get(0));
        assertEquals(new Coordinate(1374835, 2000000), coordinates.get(1));
    }
    
    @Test
    public void testReadNegativeCoordinates() {
        List<Coordinate> coordinates = IntegerReader.readCoordinates("Sensor at x=2813357, y=5535: closest beacon is at x=3595763, y=-77322");
        assertEquals(2, coordinates.size());
        
        assertEquals(new Coordinate(2813357, 5535), coordinates.get(0));
        assertEquals(new Coordinate(3595763, -77322), coordinates.get(1));
    }
}
