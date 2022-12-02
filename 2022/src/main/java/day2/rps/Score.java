package day2.rps;

import lombok.Getter;

/**
 * A simple score accumulator
 *
 */
public class Score {

    @Getter
    private int score = 0;

    public void increment(int by) {
        score += by;
    }
}
