package shared;

/**
 * A Vector in the X plane
 */
public class VectorX extends Vector {

    public VectorX(final Coordinate c1, final Coordinate c2) {
        super(c1, c2);
    }

    @Override
    protected int get(final Coordinate c) {
        return c.getX();
    }

    @Override
    protected Coordinate make(final int val) {
        return new Coordinate(val, c1.getY());
    }
}
