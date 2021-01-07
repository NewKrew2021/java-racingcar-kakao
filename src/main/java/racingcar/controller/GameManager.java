package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class GameManager {
    private static Round round;
    private static Cars cars;

    public static void main(String[] argv) {
        cars = new Cars(InputView.inputCarNames());

        round = new Round(InputView.inputRound());
        round.startRound(cars);

        result();
    }

    private static void result() {
        ResultView.printWinner(cars.getWinner());
    }
    
}
