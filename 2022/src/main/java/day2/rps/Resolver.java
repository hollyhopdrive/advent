package day2.rps;

import lombok.RequiredArgsConstructor;

/**
 * Evaluates which play wins and increments scores
 */
@RequiredArgsConstructor
public class Resolver {

	private final Score p1;
	private final Score p2;

	public void resolve(Play p1Play, Play p2Play) {
		
		p1.increment(p1Play.getValue());
		p2.increment(p2Play.getValue());
		
		if(p1Play.equals(p2Play)) {
			p1.increment(Rules.POINTS_FOR_TIE);
			p2.increment(Rules.POINTS_FOR_TIE);
		} else {
			Score winner = p1Play.beats(p2Play) ? p1 : p2;
			winner.increment(Rules.POINTS_FOR_WIN);
		}
	}
}
