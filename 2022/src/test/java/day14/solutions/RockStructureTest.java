package day14.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import day14.solutions.rocks.RockStructure;
import shared.Coordinate;

public class RockStructureTest {

    @Test
    public void testParseStructure() {
        RockStructure structure = RockStructure.Parser.parse("503,4 -> 502,4 -> 502,9 -> 494,9");
        List<Coordinate> path = structure.getPath();
        
        assertEquals(4, path.size());
        assertEquals(new Coordinate(503, 4), path.get(0));
        assertEquals(new Coordinate(502, 4), path.get(1));
        assertEquals(new Coordinate(502, 9), path.get(2));
        assertEquals(new Coordinate(494, 9), path.get(3));
    }
}
