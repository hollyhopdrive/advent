package day02.solutions.rps;



import shared.Counter;

import lombok.RequiredArgsConstructor;

/**
 * Evaluates which play wins and increments scores
 */
@RequiredArgsConstructor
public class Resolver {

    private final Counter p1;
    private final Counter p2;

    public void resolve(Play p1Play, Play p2Play) {

        p1.add(p1Play.getValue());
        p2.add(p2Play.getValue());

        if (p1Play.equals(p2Play)) {
            p1.add(Rules.POINTS_FOR_TIE);
            p2.add(Rules.POINTS_FOR_TIE);
        } else {
            Counter winner = p1Play.beats(p2Play) ? p1 : p2;
            winner.add(Rules.POINTS_FOR_WIN);
        }
    }
}
