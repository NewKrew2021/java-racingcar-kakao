package racingcar.domain;

import racingcar.exception.InvalidRoundLengthException;

import java.util.Objects;

public class Round {
    private int round;

    public Round(int round) {
        if (round < 1) {
            throw new InvalidRoundLengthException();
        }
        this.round = round;
    }

    public int getRound() {
        return round;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round1 = (Round) o;
        return round == round1.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }
}
