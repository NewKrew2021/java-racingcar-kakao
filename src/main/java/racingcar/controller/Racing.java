package racingcar.controller;

import racingcar.util.CheckMovableByRandomNumber;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingCarsFactory;
import racingcar.view.InputScanner;
import racingcar.view.PrintRacing;

public class Racing {
    private RacingCars racingCars;
    private int round;

    public Racing(String carNames, int round) {
        this.racingCars = RacingCarsFactory.from(carNames, new CheckMovableByRandomNumber());
        this.round = round;
    }

    public void play() {
        playAndShowRound();
        PrintRacing.printWinners(racingCars);
    }

    private void playAndShowRound() {
        PrintRacing.printResultSentence();
        for (int i = 0; i < this.round; i++) {
            this.racingCars.playRound();
            PrintRacing.printRoundResult(this.racingCars);
        }
    }

    public static void main(String[] args) {
        new Racing(InputScanner.inputName(), InputScanner.inputRound()).play();
    }
}
