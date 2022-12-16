package day14.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import day14.solutions.rocks.CaveBuilder;
import day14.solutions.rocks.RockStructure;
import shared.GridInterface;

public class CaveBuilderTest {

    @Test
    public void testCreateCave() {
        
        List<RockStructure> structures = List.of(
                RockStructure.Parser.parse("498,4 -> 498,6 -> 496,6"),
                RockStructure.Parser.parse("503,4 -> 502,4 -> 502,9 -> 494,9"));
        GridInterface cave = CaveBuilder.createCave(structures, false);
        System.out.println(cave.toString());
        assertEquals(
                    "......+...\n"
                  + "..........\n"
                  + "..........\n"
                  + "..........\n"
                  + "....#...##\n"
                  + "....#...#.\n"
                  + "..###...#.\n"
                  + "........#.\n"
                  + "........#.\n"
                  + "#########.\n", 
                cave.toString());
    }
}
