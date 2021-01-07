package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.TryNo;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameApp {

    public static void main(String[] args) {

        List<String> carNames = InputView.getCarNames();
        TryNo tryNo = InputView.getTryNo();

        RacingGame racingGame = new RacingGame(carNames, tryNo);

        OutputView.printResultMessage();
        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printCars(racingGame.getCars());
        }

        OutputView.printWinners(racingGame.getWinners());

    }
}
