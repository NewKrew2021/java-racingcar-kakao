package controller;

import domain.Racing;
import view.RacingGameView;

public class RacingGame {
    private Racing racing;

    public RacingGame() {

    }

    public void run() {
        this.beforeRace();
        this.repeatRace();
        this.afterRace();
    }

    public void beforeRace() {
        RacingGameView.startMessagePrint();
        String carNames = RacingGameView.getCarNames();

        RacingGameView.tryMessagePrint();
        int progressNumber = RacingGameView.getProgressNumber();
        this.racing = new Racing(carNames, progressNumber);

        RacingGameView.runResult();
    }

    public void repeatRace() {
        while (racing.isNotFinished()) {
            racing.race();
            RacingGameView.print(racing.getRaceString() + "\n");
            racing.decreaseProgressNumber();
        }
    }

    public void afterRace() {
        RacingGameView.print(racing.result());
    }
}
