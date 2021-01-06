package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.RacingGameView;

public class RacingGameController {

    private RacingGame racingGame;
    private RacingGameView racingGameView;

    public void startRacingGame() {
        this.racingGameView = new RacingGameView();
        this.racingGame = new RacingGame(this.racingGameView.getCarNames());

        int iterationNumber = racingGameView.getIterNo();
        for (int i = 0; i < iterationNumber; i++) {
            runGames(racingGame, racingGameView);
        }

        racingGameView.printResult(racingGame);
    }

    private void runGames(RacingGame racingGame, RacingGameView racingGameView) {
        racingGame.racing();
        racingGameView.printStatus(racingGame.getStatus());
    }

}
