package day09.solutions;

import shared.Coordinate;
import shared.Direction;

public class Tail extends Knot {

    public Tail(final Tail follower) {
        super(new Coordinate(0, 4), follower);
    }
    
    public Coordinate follow(final Coordinate head) {
        
        // Get the distance to the head in each direction
        int distdirX = head.getX() - location.getX();
        int distdirY = head.getY() - location.getY();

        // check for X axis move
        if(Math.abs(distdirX) == 2 || Math.abs(distdirX) + Math.abs(distdirY) > 2) {
            Direction direction = distdirX > 0 ? Direction.R : Direction.L;
            location = new Coordinate(location.getX() + direction.getXAdjust(), location.getY());
        }  
        if(Math.abs(distdirY) == 2 || Math.abs(distdirX) + Math.abs(distdirY) > 2) {
            Direction direction = distdirY > 0 ? Direction.D : Direction.U;
            location = new Coordinate(location.getX(), location.getY() + direction.getYAdjust());
        } 

        return moveTail();
    }
}
