package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RandomMoveDecisionStrategy;
import racingcar.domain.Round;
import racingcar.utils.Splitter;
import racingcar.view.UserInputView;
import racingcar.view.UserOutputView;

public class PlayRacingMain {

    public static void main(String[] args){
        Cars cars = new Cars(Splitter.splitNames(UserInputView.enterCarNames()));
        Round round = new Round(UserInputView.enterRound());

        RandomMoveDecisionStrategy randomStrategy = new RandomMoveDecisionStrategy();
        UserOutputView.printProcessTitle();
        while (!round.isEndRound()) {
            round.spendOneRound();
            cars.move(randomStrategy);
            UserOutputView.printProcessStatus(cars.getCars());
        }

        UserOutputView.printWinnerName(cars.getWinnerNames());
    }
}
