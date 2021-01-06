/*
 * File     : RacingGameMain.java
 * Date     : 2021. 01. 06
 */
package racing;

import racing.domain.RacingGameLogic;
import racing.view.RacingInputUI;
import racing.view.RacingOutputUI;

/*
 * Class    : RacingGameMain
 * Version  : 1.3
 * author   : eli.nabro
 *
 * Racing game main class
 */
public class RacingGameMain {

    public static void main(String[] args) {
        RacingGameMain racingGameMain = new RacingGameMain();
        racingGameMain.run();
    }

    public void run() {
        RacingGameLogic racingGameLogic = new RacingGameLogic(RacingInputUI.inputCarNames());
        int noTrials = RacingInputUI.inputNumberOfTrials();

        RacingOutputUI.printPreRacingResult();
        while (racingGameLogic.checkPosition(noTrials)) {
            racingGameLogic.race();
            RacingOutputUI.racePrint(racingGameLogic.getCars());
        }
        RacingOutputUI.printWinner(racingGameLogic.whoAreWinner(noTrials));
    }

}
