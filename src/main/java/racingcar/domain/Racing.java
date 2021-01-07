package racingcar.domain;

import racingcar.domain.RacingCars;
import racingcar.domain.RacingCarsFactory;
import racingcar.view.PrintRacing;

public class Racing {
    private final int ZERO = 0;

    private RacingCars racingCars;
    private int round;

    public Racing(String carNames, int round) {
        this.racingCars = RacingCarsFactory.randomNumberCars(carNames);
        this.round = round;
    }

    public RoundResult playRound() {
        this.round--;
        return this.racingCars.playRound();
    }

    public boolean isEnd() {
        return round <= ZERO;
    }

    public String[] getWinners() {
        return this.racingCars.getWinners();
    }
}
