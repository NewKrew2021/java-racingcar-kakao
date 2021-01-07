package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Main {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.getNames(), InputView.getTime());
        OutputView.printResult();

        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printDistance(racingGame.getCars());
        }

        OutputView.printWinner(racingGame.getWinners());
    }
}
