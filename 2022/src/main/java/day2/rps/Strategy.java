package day2.rps;

/**
 * Implements a strategy to pick Play based on the strategy guide
 *
 */
public interface Strategy {

	Play getPlay(Play opponentPlay, String strategyCode);
}
