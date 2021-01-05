package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.RacingGameView;

public class RacingGameController {
    private static RacingGameView racingGameView = new RacingGameView();
    private static RacingGame racingGame;

    public static void main(String[] args) {
        String carNames = racingGameView.getCarNames();
        racingGame = new RacingGame(carNames);

        int iterationNumber = racingGameView.getIterNo();
        for (int i = 0; i < iterationNumber; i++) {
            racingGame.racing();
            racingGameView.printStatus(racingGame.getStatus());
        }

        racingGameView.printResult(racingGame);
    }
}
