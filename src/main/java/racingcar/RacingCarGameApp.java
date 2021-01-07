package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.view.GameView;

public class RacingCarGameApp {
    public static void main(String[] args) {
        String text = GameView.getText();
        int tryNo = GameView.getTryNo();

        RacingCarGame game = new RacingCarGame(text, tryNo);

        while (!game.isEnd()) {
            game.racingGame();
            GameView.printRacing(game);
        }

        GameView.printWinners(game);
    }
}
