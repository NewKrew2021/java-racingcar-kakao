import domain.RacingGame;
import view.InputView;
import view.ResultView;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] names = InputView.getNames();
        int finalRound = InputView.getFinalRound();

        RacingGame game = new RacingGame(names, finalRound);
        ResultView.printHeader();
        while(!game.isEnd()){
            game.playRound();
            ResultView.printProgress(game.getCars());
        }

        ResultView.printWinners(game.getWinners());
    }
}
