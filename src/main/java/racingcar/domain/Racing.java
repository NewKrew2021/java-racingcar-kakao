package racingcar.domain;

import racingcar.view.ResultPrinter;

import java.util.Objects;

public class Racing {
    private RacingCars racingCars;
    private RoundNumber roundNumber;

    public Racing(String names, int roundNumber) {
        racingCars = new RacingCars(names);
        this.roundNumber = new RoundNumber(roundNumber);
    }

    public void play() {
        roundNumber.runRound();
        racingCars.runRound();
    }

    public boolean isRoundRemain() {
        return roundNumber.isRoundRemain();
    }

    public Winners getWinners() {
        return racingCars.getWinners();
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Racing racing = (Racing) o;
        return Objects.equals(racingCars, racing.racingCars) && Objects.equals(roundNumber, racing.roundNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars, roundNumber);
    }

}
