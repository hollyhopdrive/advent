package shared;

import lombok.Getter;

@Getter
public class Coordinate {

    private int x;
    private int y;
    
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Coordinate(final Coordinate c) {
        this(c.getX(), c.getY());
    }
    
    /**
     * Accepts coordinates in the form "x,y" and parses to a Coordinate instance
     */
    public static Coordinate parse(String value) {
        final String[] xy = value.split(",");
        return new Coordinate(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return String.format("[%d, %d]", x, y);
    }
}
