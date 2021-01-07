package racingcar.domain;

import java.util.Objects;

public class RoundNumber {
    private int roundNumber;

    public RoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void runRound() {
        this.roundNumber--;
    }

    public boolean isRoundRemain() {
        return roundNumber > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundNumber that = (RoundNumber) o;
        return roundNumber == that.roundNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundNumber);
    }
}
