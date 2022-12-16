package day08.solutions.trees;

import lombok.RequiredArgsConstructor;
import shared.Coordinate;
import shared.Direction;
import shared.Grid;
import shared.GridAnalyzer;
import shared.GridInterface;

@RequiredArgsConstructor
public class ScenicAnalyzer implements GridAnalyzer {
    
    private final GridInterface grid;
    
    public int analyze() {
    
        int maxScore = 0;
        
        // We know the scenic score for all outer trees is 0, so don't consider them
        for(int x = 1; x < grid.getSizeX() - 1; ++x) {
            for(int y = 1; y < grid.getSizeY() -1; ++y) {
                maxScore = Math.max(maxScore,  scenicScore(new Coordinate(x, y)));
            }
        }
        
        return maxScore;
    }
    
    public int scenicScore(final Coordinate location) {
        return countVisible(location, Direction.L) 
                * countVisible(location, Direction.R) 
                * countVisible(location, Direction.U)
                * countVisible(location, Direction.D);
    }
    
    private int countVisible(final Coordinate location, final Direction d) {
        int visible = 0;
        
        Coordinate next = grid.translate(location, d);
        
        while(next != null) {
            visible++;
            if(grid.getValue(next) >= grid.getValue(location)) {
                break;
            }
            next = grid.translate(next, d);
            
        }
        return visible;
    }
}
