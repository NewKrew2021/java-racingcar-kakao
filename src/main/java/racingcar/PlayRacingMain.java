package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.RandomConditionValueStrategy;
import racingcar.view.UserInputView;
import racingcar.view.UserOutputView;

public class PlayRacingMain {

    public static void main(String[] args){
        String names = UserInputView.enterCarNames();
        int round = UserInputView.enterRound();
        Racing rc = new Racing(names, round);

        RandomConditionValueStrategy randomStrategy = new RandomConditionValueStrategy();
        UserOutputView.printProcessTitle();
        while (!rc.isFinish()) {
            rc.race(randomStrategy);
            UserOutputView.printProcessStatus(rc.getCarsMidTermStatus());
        }

        UserOutputView.printWinnerName(rc.getWinnerNames());
    }
}
