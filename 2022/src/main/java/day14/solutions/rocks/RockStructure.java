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
