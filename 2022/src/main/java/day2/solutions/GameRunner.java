package day2.solutions;

import java.util.List;

import day2.rps.RockPaperScissors;
import day2.rps.Score;
import day2.rps.Strategy;
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
		final Score p1Score = new Score();
		final Score p2Score = new Score();
		final RockPaperScissors game = new RockPaperScissors(strategy, p1Score, p2Score);
		
		lines.forEach(l -> game.playRound(l));
		
		return p2Score.getScore();
	}
}
