package racingcar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import racingcar.domain.InvalidCarNameException;
import racingcar.domain.InvalidGameCountException;
import racingcar.domain.RacingGame;
import racingcar.view.RacingGameView;

public class RacingGameController {

    private RacingGame racingGame;
    private RacingGameView racingGameView;
    private static final Logger logger = LoggerFactory.getLogger(RacingGameController.class.getName());

    public RacingGameController() {
        racingGameView = new RacingGameView();
    }

    public void startRacingGame() {
        if (isRacingGameSettingIsValid()) {
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
            logger.error(runtimeException.toString());
            return false;
        }
        return true;
    }

    private void runGames() {
        while (!racingGame.isGameEnd()) {
            racingGame.racing();
            racingGameView.printStatus(racingGame.getCarInfos());
        }
    }

}
