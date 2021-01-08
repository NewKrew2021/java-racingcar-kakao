import domain.RacingGame;
import view.InputView;
import view.OutputView;

public class RacingGameApp {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int roundNo = InputView.getRoundNo();
        RacingGame game = new RacingGame(roundNo, carNames);

        OutputView.printExecResultSentence();
        while (!game.isEnd()) {
            game.playRound();
            OutputView.printCars(game.getCars());
        }
        OutputView.printWinners(game.getWinners());
    }

}
