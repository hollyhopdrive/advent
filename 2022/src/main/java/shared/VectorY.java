package shared;

/**
 * A Vector in the X plane
 */
public class VectorY extends Vector {

    public VectorY(final Coordinate c1, final Coordinate c2) {
        super(c1, c2);
    }

    @Override
    protected int get(final Coordinate c) {
        return c.getY();
    }

    @Override
    protected Coordinate make(final int val) {
        return new Coordinate(c1.getX(), val);
    }
}
