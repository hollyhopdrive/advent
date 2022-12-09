package day09.solutions;

public class Head extends Knot {


    
    public Head(final Tail follower) {
        super(new Coordinate(0, 0), follower);
    }
    
    /**
     * Move the head 1 space, and all followers. Returns the coordinate of the final tail
     */
    public Coordinate move(final Direction direction) {
        location = new Coordinate(
                location.getX() + direction.getXAdjust(), 
                location.getY() + direction.getYAdjust());
        
        return moveTail();
    }
}
