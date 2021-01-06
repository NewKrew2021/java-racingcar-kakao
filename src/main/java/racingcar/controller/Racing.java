package racingcar.controller;

import racingcar.domain.CheckMovableByRandomNumber;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingCarsFactory;
import racingcar.util.InputScanner;

public class Racing {
    private RacingCars racingCars;
    private int round;

    public void play() {
        getInput();
        playAndShowRound();
        printFinalResult();
    }

    private void getInput() {
        this.racingCars = RacingCarsFactory.from(InputScanner.inputName(), new CheckMovableByRandomNumber());
        this.round = InputScanner.inputRound();
    }

    private void playAndShowRound() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < this.round; i++) {
            this.racingCars.run();
            printRoundResult();
        }
    }

    private void printRoundResult() {
        this.racingCars.printRoundResult();
        System.out.println();
    }

    private void printFinalResult() {
        System.out.print(this.racingCars.getWinners());
        System.out.println("가 최종 우승했습니다.");
    }

}
