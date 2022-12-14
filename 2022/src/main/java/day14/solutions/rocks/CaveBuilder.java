package day14.solutions.rocks;

import java.util.List;
import java.util.stream.Collectors;

import shared.Coordinate;
import shared.Grid;

public class CaveBuilder {

    public static final Coordinate SAND_SOURCE = new Coordinate(500, 0);
    
    public static Grid createCave(final List<RockStructure> structures, final boolean withFloor) {
        
        int maxY = structures.stream().map(s -> s.maxY()).collect(Collectors.maxBy(Integer::compare)).get();
        if(withFloor) {
            // If the floor is added, then it will be 2 levels below maxY, increasing maxY by 2
            maxY += 2;
            structures.add(createFloor(maxY));
        }
        
        final int maxX = Math.max(
                structures.stream().map(s -> s.maxX()).collect(Collectors.maxBy(Integer::compare)).get(), 
                SAND_SOURCE.getX());
        
        final int minX = Math.min(
                structures.stream().map(s -> s.minX()).collect(Collectors.minBy(Integer::compare)).get(),
                SAND_SOURCE.getX());
        
        // We know the roof of the cave is always at y=0, because that's where the sand source is
        final int minY = 0; 
        
        final Grid cave = new Grid(maxY - minY + 1, maxX - minX + 1, minY, minX);
        fillCave(cave, structures);
        return cave;
    }
    
    /**
     * The floor is not really horizontally infinite. 
     * It's extents (for our simulator purpose) can be determined as a function of the cave height,
     * which is in turn derived from the other rock structures
     */
    private static RockStructure createFloor(final int maxY) {
        
        // The length of the floor is a function of maxY (it's essentially a triangle with the sand source at the top)
        int length = 1 + ((maxY) * 2) + 2;
        
        // And it is positioned centrally from the sand source
        final Coordinate floorLeft = new Coordinate(CaveBuilder.SAND_SOURCE.getX() - length / 2, maxY);
        final Coordinate floorRight = new Coordinate(CaveBuilder.SAND_SOURCE.getX() + length / 2, maxY);
        
        // Now define it as a RockStructure
        return new RockStructure(List.of(floorLeft, floorRight));
    }
    
    /**
     * Fill the cave with air, the sand source, and rocks
     */
    private static void fillCave(final Grid cave, final List<RockStructure> structures) {
        cave.setValueAll(Symbol.AIR);
        cave.setValue(new Coordinate(500, 0), Symbol.SOURCE);
        
        structures.forEach(s -> {
            s.expand().forEach(v -> {
                v.expand().forEach(c -> {
                    cave.setValue(c, Symbol.ROCK);
                });
            });
        });
    }
}
