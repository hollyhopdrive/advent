package day02.solutions;

import java.util.List;

import day02.rps.RockPaperScissors;
import day02.rps.Strategy;
import shared.Counter;
import shared.InputReader;

public class GameRunner {

	/**
	 * Run the game and return _my_ (p2) score
	 * @param path Input data file path
	 * @param strategy The strategy to use for selecting p2 plays
	 * @return p2 score
	 */
	public static int run(String path, Strategy strategy) {
		
		final List<String> lines = new InputReader().readInputFile(path);
		final Counter p1Score = new Counter();
		final Counter p2Score = new Counter();
		final RockPaperScissors game = new RockPaperScissors(strategy, p1Score, p2Score);
		
		lines.forEach(l -> game.playRound(l));
		
		return p2Score.getValue();
	}
}
