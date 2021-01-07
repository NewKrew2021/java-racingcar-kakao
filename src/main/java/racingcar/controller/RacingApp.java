package racingcar.controller;

import racingcar.domain.Racing;
import racingcar.view.InputScanner;
import racingcar.view.PrintRacing;

public class RacingApp {

    public static void main(String[] args) {
        Racing racing = new Racing(InputScanner.inputName(), InputScanner.inputRound());
        PrintRacing.printResultSentence();
        while(!racing.isEnd()) {
            PrintRacing.printRoundResult(racing.playRound());
        }
        PrintRacing.printWinners(racing.getWinners());
    }

}
