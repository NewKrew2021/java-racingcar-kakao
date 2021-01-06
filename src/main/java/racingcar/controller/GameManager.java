package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.exception.InvalidRoundLengthException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameManager {
    private int round;
    private Cars cars = new Cars();


    public void start() {
        OutputView.printInputCars();
        cars.setCars(InputView.inputCarNames());

        OutputView.printInputRound();
        setRound(InputView.inputRound());

        startRound();
        result();
    }

    private void startRound() {
        for (int i = 0; i < round; i++) {
            cars.move();
            OutputView.print(cars.getRoundResult());
        }
    }

    public void setRound(int round) {
        roundLengthCheck(round);
        this.round = round;
        OutputView.printRoundStart();
    }

    private void roundLengthCheck(int round) {
        if (round < 1) {
            throw new InvalidRoundLengthException("횟수를 1회 이상 입력해주세요.");
        }
    }


    public void result() {
        OutputView.printWinner(cars.getWinner());
    }


}
