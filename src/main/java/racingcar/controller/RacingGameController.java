package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.RacingGameView;

public class RacingGameController {

    public static void main(String[] args) {
        RacingGameView racingGameView = new RacingGameView();
        String carNames = racingGameView.getCarNames();
        RacingGame racingGame = new RacingGame(carNames);

        int iterationNumber = racingGameView.getIterNo();
        for (int i = 0; i < iterationNumber; i++) {
            runGames(racingGame, racingGameView);
        }

        racingGameView.printResult(racingGame);
    }

    public static void runGames(RacingGame racingGame, RacingGameView racingGameView) {
        racingGame.racing();
        racingGameView.printStatus(racingGame.getStatus());
    }

}
