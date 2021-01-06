package racingcar;


import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameApp {

    public static void main(String[] args) {

        String[] carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();

        RacingGame racingGame = new RacingGame(carNames, tryNo);

        OutputView.printResultMessage();
        while(!racingGame.isEnd()){
            racingGame.race();
            OutputView.printCars(racingGame.getCars());
        }

        OutputView.printWinners(racingGame.getWinners());

    }
}
