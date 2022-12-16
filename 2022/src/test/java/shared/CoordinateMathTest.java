package shared;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class CoordinateMathTest {

    @Test
    public void testManhattenDistance() {
        assertEquals(0, CoordinateMath.distance(new Coordinate(1,1), new Coordinate(1,1)));
        assertEquals(1, CoordinateMath.distance(new Coordinate(1,1), new Coordinate(1,0)));
        assertEquals(1, CoordinateMath.distance(new Coordinate(0,1), new Coordinate(1,1)));
        assertEquals(2, CoordinateMath.distance(new Coordinate(1,1), new Coordinate(0,0)));
        assertEquals(3, CoordinateMath.distance(new Coordinate(1,1), new Coordinate(-1,0)));
        assertEquals(3, CoordinateMath.distance(new Coordinate(1,1), new Coordinate(0,-1)));
        assertEquals(4, CoordinateMath.distance(new Coordinate(1,1), new Coordinate(-1,-1)));
    }
    
    @Test
    public void testFindAllAtDistanceOne() {
        
        final Coordinate c = new Coordinate(2,2);
        Set<Coordinate> atDistance = CoordinateMath.findAllAtDistance(c, 1);
        assertEquals(4, atDistance.size());
        assertTrue(atDistance.contains(new Coordinate(1,2)));
        assertTrue(atDistance.contains(new Coordinate(3,2)));
        assertTrue(atDistance.contains(new Coordinate(2,1)));
        assertTrue(atDistance.contains(new Coordinate(2,3)));
    }
    
    @Test
    public void testFindAllAtDistanceTwo() {
        
        final Coordinate c = new Coordinate(3,3);
        Set<Coordinate> atDistance = CoordinateMath.findAllAtDistance(c, 2);
        assertEquals(8, atDistance.size());
        assertTrue(atDistance.contains(new Coordinate(3,1)));
        assertTrue(atDistance.contains(new Coordinate(4,2)));
        assertTrue(atDistance.contains(new Coordinate(5,3)));
        assertTrue(atDistance.contains(new Coordinate(4,4)));
        
        assertTrue(atDistance.contains(new Coordinate(3,5)));
        assertTrue(atDistance.contains(new Coordinate(2,4)));
        assertTrue(atDistance.contains(new Coordinate(1,3)));
        assertTrue(atDistance.contains(new Coordinate(2,2)));
    }
}
