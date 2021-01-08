package racingcar.domain;

import racingcar.exception.InvalidRoundValueException;

import java.util.Objects;

public class Round {

    private static final int MIN_ROUND_VALUE = 0;
    private static final String ROUND_EXCEPTION_MESSAGE = "0 이상의 이동 횟수를 입력하세요.";

    private int round;

    public Round(int round) {
        validateRoundValue(round);
        this.round = round;
    }

    public void spendOneRound() {
        this.round--;
    }

    public boolean isEndRound() {
        return this.round == 0;
    }

    private void validateRoundValue(int round) {
        if (round < MIN_ROUND_VALUE) {
            throw new InvalidRoundValueException(ROUND_EXCEPTION_MESSAGE);
        }
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
