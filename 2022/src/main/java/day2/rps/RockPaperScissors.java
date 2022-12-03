package day2.rps;

import shared.Counter;

public class RockPaperScissors {

    private final Strategy strategy;
    private final Resolver resolver;

    public RockPaperScissors(final Strategy strategy, final Counter p1, final Counter p2) {
        this.strategy = strategy;
        this.resolver = new Resolver(p1, p2);
    }

    public void playRound(final String input) {
        String[] codes = input.split(" ");
        Play p1Play = Play.fromCode(codes[0]);
        Play p2Play = strategy.getPlay(p1Play, codes[1]);

        resolver.resolve(p1Play, p2Play);
    }
}
