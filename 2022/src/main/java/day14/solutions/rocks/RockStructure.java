package day14.solutions.rocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shared.Coordinate;
import shared.Vector;

@RequiredArgsConstructor
public class RockStructure {

    public static final class Parser {
        
        public static RockStructure parse(final String line) {
            String[] coordinates = line.split(" -> ");
            return new RockStructure(Arrays.stream(coordinates).map(c -> Coordinate.parse(c)).collect(Collectors.toList()));
        }
    }
    
    @Getter
    private final List<Coordinate> path;
    
    public int minX() {
        return path.stream().map(p -> p.getX()).collect(Collectors.minBy(Integer::compare)).get();
    }
    
    public int maxX() {
        return path.stream().map(p -> p.getX()).collect(Collectors.maxBy(Integer::compare)).get();
    }
    
    public int minY() {
        return path.stream().map(p -> p.getY()).collect(Collectors.minBy(Integer::compare)).get();
    }
    
    public int maxY() {
        return path.stream().map(p -> p.getY()).collect(Collectors.maxBy(Integer::compare)).get();
    }
    
    /**
     * Expand the basic rock structure co-ordinates to a list of Vectors
     */
    public List<Vector> expand() {
        final List<Vector> expansion = new ArrayList<>();
        
        for(int i = 0; i < path.size() - 1; ++i) {
            expansion.add(Vector.create(path.get(i), path.get(i+1)));
        }
        
        return expansion; 
    }
    
    @Override
    public String toString() {
        return path.toString();
    }
}
