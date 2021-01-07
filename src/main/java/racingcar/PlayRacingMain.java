package racingcar;

import racingcar.domain.Racing;
import racingcar.view.UserView;

public class PlayRacingMain {

    public static void main(String[] args){
        String names = UserView.enterCarNames();
        int round = UserView.enterRound();
        Racing rc = new Racing(names, round);

        UserView.printProcessTitle();
        while (!rc.isFinish()) {
            rc.race();
            UserView.printProcessStatus(rc.getCarsMidTermStatus());
        }

        UserView.printWinnerName(rc.getWinnerNames());
    }
}
