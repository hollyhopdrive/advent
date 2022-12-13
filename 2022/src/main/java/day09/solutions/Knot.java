package day09.solutions;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import shared.Coordinate;

@AllArgsConstructor
public abstract class Knot {

    @Getter
    protected Coordinate location;
    
    @Getter(value=AccessLevel.PROTECTED)
    private final Tail follower;   
    
    protected Coordinate moveTail() {
        // If there is a knot behind us, tell it to follow now
        return follower != null ? follower.follow(location) : location;
    }
}
