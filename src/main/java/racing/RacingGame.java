/*
 * File     : RacingGame.java
 * Date     : 2021. 01. 06
 */
package racing;

import java.util.List;

/*
 * Class    : RacingGame
 * Version  : 1.2
 * author   : eli.nabro
 *
 * Racing game class
 */
public class RacingGame {

    private RacingGameLogic racingGameLogic;
    private int numberOfTrials = 0;

    public RacingGame() {

    }

    public RacingGame(String in) {
        RacingInputUI.setInputStreamForTest(in);
    }

    public void run() {
        RacingOutputUI.printCarNameQuestion();
        this.setCarsName(RacingInputUI.inputCarNames());
        RacingOutputUI.printTrialsQuestion();
        this.numberOfTrials = RacingInputUI.inputNumberOfTrials();
        this.playRacingGame(this.numberOfTrials);
        RacingOutputUI.printWinner(this.racingGameLogic.whoAreWinner(this.numberOfTrials));
    }

    public void setCarsName(String carNames) {
        this.racingGameLogic = new RacingGameLogic(carNames);
    }

    public List<Integer> playRacingGame(int numbers) {
        RacingOutputUI.printPreRacingResult();
        while (this.racingGameLogic.checkPosition(numbers)) {
            this.racingGameLogic.race();
            RacingOutputUI.racePrint(this.racingGameLogic.getCars());
        }
        return this.racingGameLogic.getCarsPosition();
    }

}
