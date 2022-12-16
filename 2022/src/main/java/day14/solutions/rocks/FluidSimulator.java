package day14.solutions.rocks;

import shared.Coordinate;
import shared.Direction;
import shared.GridAnalyzer;
import shared.GridInterface;

public class FluidSimulator implements GridAnalyzer {

    private final GridInterface cave;
    
    // The source of the sand
    private final Coordinate sandSource;
    
    private boolean terminated;
    
    public FluidSimulator(final GridInterface cave, final Coordinate sandSource) {
        this.cave = cave;
        this.sandSource = sandSource;
        terminated = false;
    }
    
    /**
     * Run the simulation. Return the count of the units of sand that fell before falling into the abyss.
     */
    @Override
    public int analyze() {
        
        Coordinate sand = spawn();
        Coordinate to = null;
                
        while(!terminated) {
            while(
                (to = fall(sand, Direction.D)) != sand || 
                (to = fall(sand, Direction.L)) != sand || 
                (to = fall(sand, Direction.R)) != sand) {
                    
                    // If no place to fall to, then this sand is at rest now
                    if(to == null) {
                        break; 
                    }
                    
                    sand = to;
            }
           
            if(!terminated) {
                cave.setValue(sand, Symbol.SAND);
                sand = spawn();
            }
        }
        
        // The count is how many are at rest
        return cave.count(Symbol.SAND);
    }
    
    private Coordinate spawn() {
        if(cave.getValue(sandSource) == Symbol.SAND) {
            // All clogged up
            terminated = true;
            return null;
        }

        return sandSource;
    }
    
    private Coordinate fall(final Coordinate sand, final Direction d) {
        
        // Always move down
        Coordinate to = cave.translate(sand, Direction.D);
        
        // Apply diagonal move, if moving L or R
        if(to != null && d != Direction.D) {
            to = cave.translate(to, d);
        }
        
        if(to == null) {
            // We're off the grid (in part 1), or we're still at the spawn point (in part 2).
            // This is the end of the simulation
            terminated = true;
            return null;
        }
        
        // Check for obstacle
        if(cave.getValue(to) != Symbol.AIR) {
            // Cannot be moved, return the same location
            //System.out.println("Sand at rest at " + sand);
            return sand;
        }
        
        return to;
    }
}
