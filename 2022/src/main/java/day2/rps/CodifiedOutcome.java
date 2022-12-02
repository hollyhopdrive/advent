package day2.rps;

public class CodifiedOutcome implements Strategy {

	@Override
	public Play getPlay(Play opponentPlay, String strategyCode) {
		switch(strategyCode) {
			case "X": return opponentPlay.capitulate();
			case "Y": return opponentPlay;
			case "Z": return opponentPlay.trump();
		}
		throw new IllegalArgumentException("Invalid Code");
	}
}
