package day09.solutions;

public class Head extends Knot {

    public Head() {
        super(new Coordinate(0, 0));
        System.out.println("HEAD: " + location.toString());
    }
    
    public Coordinate move(final Direction direction) {
        location = new Coordinate(
                location.getX() + direction.getXAdjust(), 
                location.getY() + direction.getYAdjust());
        
        System.out.println("HEAD: " + location.toString());
        return location;
    }
}
