package racingcar;

import racingcar.domain.Racing;
import racingcar.view.InputScanner;
import racingcar.view.ResultPrinter;

public class RacingApp {

    public static void main(String[] args) {
        String names = InputScanner.scanName();
        int round = InputScanner.scanRound();
        Racing racing = new Racing(names, round);
        ResultPrinter.printResultWord();
        while (racing.isRoundRemain()) {
            racing.play();
            ResultPrinter.printRoundResult(racing.getRacingCars());
        }
        ResultPrinter.printFinalResult(racing.getWinners());

    }

}
