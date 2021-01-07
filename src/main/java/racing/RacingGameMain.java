package racing;

import racing.domain.RacingGameLogic;
import racing.view.RacingInputUI;
import racing.view.RacingOutputUI;

public class RacingGameMain {

    public static void main(String[] args) {
        RacingGameMain racingGameMain = new RacingGameMain();
        racingGameMain.run();
    }

    public void run() {
        int numberOfTrials = RacingInputUI.inputNumberOfTrials();
        String carNames = RacingInputUI.inputCarNames();
        RacingGameLogic racingGameLogic = new RacingGameLogic(carNames,numberOfTrials);

        RacingOutputUI.printPreRacingResult();
        while (racingGameLogic.checkPosition()) {
            racingGameLogic.race();
            RacingOutputUI.racePrint(racingGameLogic.getCars());
        }
        RacingOutputUI.printWinner(racingGameLogic.whoAreWinner());
    }

}
