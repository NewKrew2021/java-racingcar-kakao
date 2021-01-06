package racingcar.view;

import racingcar.domain.Racing;
import racingcar.utils.InputView;
import racingcar.utils.OutputView;

public class RacingMain {
    public static void main(String[] args){

        Racing rc = new Racing(InputView.enterCarNames(), InputView.enterRound());

        System.out.println("실행 결과");

        while(rc.canRace()){
            rc.oneRoundRacing();
            OutputView.printCurrentCarStatus(rc);
        }
        OutputView.printWinnerName(rc);
    }
}
