package day02.rps;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Play {

    ROCK(Rules.POINTS_FOR_ROCK), PAPER(Rules.POINTS_FOR_PAPER), SCISSORS(Rules.POINTS_FOR_SCISSORS);

    @Getter
    private final int value;

    public static Play fromCode(final String code) {
        switch (code) {

        case Codes.OPPONENT_ROCK:
        case Codes.MY_ROCK:
            return Play.ROCK;

        case Codes.OPPONENT_PAPER:
        case Codes.MY_PAPER:
            return Play.PAPER;

        case Codes.OPPONENT_SCISSORS:
        case Codes.MY_SCISSORS:
            return Play.SCISSORS;
        }

        throw new IllegalArgumentException("Invalid Play");
    }

    public boolean beats(Play other) {
        if (this.equals(Play.ROCK)) {
            return other.equals(Play.SCISSORS);
        } else if (this.equals(Play.PAPER)) {
            return other.equals(Play.ROCK);
        } else {
            return other.equals(Play.PAPER);
        }
    }

    /**
     * Return the Play that would beat this Play
     */
    public Play trump() {
        if (this.equals(Play.ROCK)) {
            return Play.PAPER;
        } else if (this.equals(Play.PAPER)) {
            return Play.SCISSORS;
        } else {
            return Play.ROCK;
        }
    }

    /**
     * Return the Play that would lose to this Play
     */
    public Play capitulate() {
        if (this.equals(Play.ROCK)) {
            return Play.SCISSORS;
        } else if (this.equals(Play.PAPER)) {
            return Play.ROCK;
        } else {
            return Play.PAPER;
        }
    }
}
