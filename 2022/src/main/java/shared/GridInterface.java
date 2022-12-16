package shared;

import java.util.List;

public interface GridInterface {

    /**
     * Get the size of Y (the number of rows)
     */
    int getSizeY();

    /**
     * Get the size of Y (the number of columns)
     */
    int getSizeX();

    /**
     * Get the current value from the location given
     */
    char getValue(Coordinate coordinate);

    /**
     * Get the current value from the location given
     */
    char getValue(int y, int x);

    /**
     * Set the specified value in the location given
     */
    void setValue(Coordinate location, char value);

    /**
     * Set the specified value in the location given
     */
    void setValue(int y, int x, char value);

    /**
     * Set the specified value for every location in the grid
     */
    void fill(char value);

    /**
     * Determine if the given coordinate is within the grid boundary
     */
    boolean contains(Coordinate c);

    /**
     * Determine if the given location is within the grid boundary
     */
    boolean contains(int x, int y);

    /**
     * Translate (move) a Coordinate by one space in the given direction.
     * Coordinates are immutable, so a new Coordinate is returned that describes the new location.
     * If the new location would be outside the boundaries of the grid, this method returns null.
     */
    Coordinate translate(Coordinate from, Direction d);

    /**
     * Count how many locations have the specified value
     */
    int count(char value);

    /**
     * Find all the locations that have the specified value
     */
    List<Coordinate> find(char value);

    /**
     * Find the first location that matches the value, starting from the top left and working right then down (like a book!)
     */
    Coordinate findFirst(char value);

}