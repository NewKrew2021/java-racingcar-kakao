package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class GameManager {
    private static Cars cars;

    public static void main(String[] argv) {
        cars = new Cars(InputView.inputCarNames());
        Round round = new Round(InputView.inputRound());

        startRound(round);
        ResultView.printWinner(cars.getWinner());
    }

    private static void startRound(Round round) {
        ResultView.printRoundStart();

        for (int i = 0; i < round.getRound(); i++) {
            cars.move();
            ResultView.print(cars.getRoundResult());
        }
    }

}
