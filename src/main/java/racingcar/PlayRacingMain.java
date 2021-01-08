package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.RandomConditionValueStrategy;
import racingcar.view.UserView;

public class PlayRacingMain {

    public static void main(String[] args){
        String names = UserView.enterCarNames();
        int round = UserView.enterRound();
        Racing rc = new Racing(names, round);

        RandomConditionValueStrategy randomStrategy = new RandomConditionValueStrategy();
        UserView.printProcessTitle();
        while (!rc.isFinish()) {
            rc.race(randomStrategy);
            UserView.printProcessStatus(rc.getCarsMidTermStatus());
        }

        UserView.printWinnerName(rc.getWinnerNames());
    }
}
