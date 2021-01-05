import domain.RacingGame;
import domain.RandomEngine;
import view.InputView;
import view.OutputView;

public class RacingCarGame {
    public static void main(String[] args) {
        RacingGame game = RacingGame.initialize(new RandomEngine(), InputView.readNames(), InputView.readRound());
        while (!game.isEnd()) {
            game.moveCars();
            OutputView.printCars(game.getCars());
        }
        OutputView.printWinnerCars(game.findWinnerCars());
    }
}
