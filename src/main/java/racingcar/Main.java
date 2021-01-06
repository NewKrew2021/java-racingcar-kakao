package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Main {
    public static void main(String[] args) {
        OutputView.printGetName();
        String names = InputView.getNames();

        OutputView.printGetTime();
        int time = InputView.getTime();

        RacingGame racingGame = new RacingGame(names, time);
        OutputView.printResult();

        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printDistance(racingGame.getCars());
        }

        OutputView.printWinner(racingGame.getWinners());
    }
}
