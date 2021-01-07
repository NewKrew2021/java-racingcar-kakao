package racingcar.domain;

import racingcar.exception.InvalidRoundValueException;

import java.util.Objects;

public class Round {

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
        if (round < 0) {
            throw new InvalidRoundValueException("0 이상의 라운드를 입력하세요.");
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
