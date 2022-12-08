package day02.solutions.rps;

public class CodifiedPlay implements Strategy {

    @Override
    public Play getPlay(Play opponentPlay, String strategyCode) {
        return Play.fromCode(strategyCode);
    }
}
