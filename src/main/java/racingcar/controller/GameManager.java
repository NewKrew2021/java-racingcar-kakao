package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameManager {
    private static Round round;
    private static Cars cars = new Cars();

    public static void main(String[] argv) {
        OutputView.printInputCars();
        cars.setCars(InputView.inputCarNames());

        OutputView.printInputRound();
        round = new Round(InputView.inputRound());

        round.startRound(cars);
        result();
    }

    private static void result() {
        OutputView.printWinner(cars.getWinner());
    }
}
