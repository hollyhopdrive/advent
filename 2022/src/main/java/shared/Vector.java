package shared;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * A straight line, in either the X or Y plane, that joins two Coordinates
 */
@RequiredArgsConstructor(access=AccessLevel.PROTECTED)
public abstract class Vector {

    public static Vector create(final Coordinate c1, final Coordinate c2) {
        return c1.getX() != c2.getX() ? new VectorX(c1, c2) : new VectorY(c1, c2);
    }
    
    protected final Coordinate c1;
    protected final Coordinate c2;
    
    /**
     * Provide a path of all Coordinates between each end of the Vector.
     * The Path is ordered (each Coordinate is adjacent to the ones before and after it in the list), 
     * but direction is arbitrary (there is no defined start or end)
     */
    public List<Coordinate> expand() {
        List<Coordinate> path = new ArrayList<Coordinate>();
        
        int start = Math.min(get(c1), get(c2));
        int end = Math.max(get(c1), get(c2));
        
        path.add(c1);
        
        for(int i = start + 1; i < end; ++i) {
            path.add(make(i));
        }
        
        path.add(c2);
        
        return path;
    }
    
    /** 
     * Get the value of the co-ordinate, in the plane of interest
     */
    protected abstract int get(Coordinate c);
    
    /**
     * Make a new co-ordinate, using the specified value for the plane of interest
     */
    protected abstract Coordinate make(int val);
}
