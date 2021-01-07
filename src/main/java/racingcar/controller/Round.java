package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.exception.InvalidRoundLengthException;
import racingcar.view.ResultView;

public class Round {
    private int round;

    public Round(int round) {
        if (round < 1) {
            throw new InvalidRoundLengthException();
        }
        this.round = round;
        ResultView.printRoundStart();
    }

    public void startRound(Cars cars) {
        for (int i = 0; i < this.round; i++) {
            cars.move();
            ResultView.print(cars.getRoundResult());
        }
    }
}
