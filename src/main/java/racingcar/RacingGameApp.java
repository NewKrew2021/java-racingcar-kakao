package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameApp {

    public static void main(String[] args) throws Exception {

        Cars cars = InputView.getCars();
        int tryNo = InputView.getTryNo();

        RacingGame racingGame = new RacingGame(cars, tryNo);

        OutputView.printResultMessage();
        while(!racingGame.isEnd()){
            racingGame.race();
            OutputView.printCars(racingGame.getCars());
        }

        OutputView.printWinners(racingGame.getWinners());

    }
}
