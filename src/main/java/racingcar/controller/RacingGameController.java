package racingcar.controller;

import racingcar.domain.InvalidCarNameException;
import racingcar.domain.InvalidGameCountException;
import racingcar.domain.RacingGame;
import racingcar.view.RacingGameView;

public class RacingGameController {

    private RacingGame racingGame;
    private RacingGameView racingGameView;

    public RacingGameController() {
        racingGameView = new RacingGameView();
    }

    public void startRacingGame() {
        if(isRacingGameSettingIsValid()) {
            runGames();

            racingGameView.printResult(racingGame);
        }
    }

    private boolean isRacingGameSettingIsValid() {
        try {
            String inputCarNames = racingGameView.getCarNames();
            int getIterationNumber = racingGameView.getIterNo();
            racingGame = new RacingGame(inputCarNames, getIterationNumber);
        } catch (InvalidCarNameException | InvalidGameCountException runtimeException) {
            System.out.println(runtimeException);
            return false;
        }
        return true;
    }

    private void runGames() {
        while(!racingGame.isGameEnd()) {
            racingGame.racing();
            racingGameView.printStatus(racingGame.getCarInfos());
        }
    }

}
