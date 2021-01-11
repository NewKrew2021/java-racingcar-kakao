package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.RandomMoveDecisionStrategy;
import racingcar.view.UserInputView;
import racingcar.view.UserOutputView;

public class PlayRacingMain {

    public static void main(String[] args){
        String names = UserInputView.enterCarNames();
        int round = UserInputView.enterRound();
        Racing racing = new Racing(names, round);

        RandomMoveDecisionStrategy randomStrategy = new RandomMoveDecisionStrategy();
        UserOutputView.printProcessTitle();
        while (!racing.isFinish()) {
            racing.race(randomStrategy);
            UserOutputView.printProcessStatus(racing.getCarsMidTermStatus());
        }

        UserOutputView.printWinnerName(racing.getWinnerNames());
    }
}
