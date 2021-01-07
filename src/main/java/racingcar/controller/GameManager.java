package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.exception.InvalidRoundLengthException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameManager {
    private static int round;
    private static Cars cars = new Cars();

    public static void main(String[] argv) {
        OutputView.printInputCars();
        cars.setCars(InputView.inputCarNames());

        OutputView.printInputRound();
        setRound(InputView.inputRound());

        startRound();
        result();
    }

    private static void startRound() {
        for (int i = 0; i < round; i++) {
            cars.move();
            OutputView.print(cars.getRoundResult());
        }
    }

    public static void setRound(int round) {
        roundLengthCheck(round);
        GameManager.round = round;
        OutputView.printRoundStart();
    }

    private static void roundLengthCheck(int round) {
        if (round < 1) {
            throw new InvalidRoundLengthException("횟수를 1회 이상 입력해주세요.");
        }
    }


    private static void result() {
        OutputView.printWinner(cars.getWinner());
    }


}
