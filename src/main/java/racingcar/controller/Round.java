package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.exception.InvalidRoundLengthException;
import racingcar.view.OutputView;

public class Round {
    private int round;

    public Round(int round) {
        if (round < 1) {
            throw new InvalidRoundLengthException();
        }
        this.round = round;
        OutputView.printRoundStart();
    }

    public void startRound(Cars cars) {
        for (int i = 0; i < this.round; i++) {
            cars.move();
            OutputView.print(cars.getRoundResult());
        }
    }
}
