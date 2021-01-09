package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.RandomMoveDecisionStrategy;
import racingcar.view.UserInputView;
import racingcar.view.UserOutputView;

public class PlayRacingMain {

    public static void main(String[] args){
        String names = UserInputView.enterCarNames();
        int round = UserInputView.enterRound();
        Racing rc = new Racing(names, round);

        RandomMoveDecisionStrategy randomStrategy = new RandomMoveDecisionStrategy();
        UserOutputView.printProcessTitle();
        while (!rc.isFinish()) {
            rc.race(randomStrategy);
            UserOutputView.printProcessStatus(rc.getCarsMidTermStatus());
        }

        UserOutputView.printWinnerName(rc.getWinnerNames());
    }
}
