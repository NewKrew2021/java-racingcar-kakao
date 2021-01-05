package racingcar;

import racingcar.model.RacingCar;
import racingcar.util.InputScanner;

import java.util.List;

public class Racing {
    private RacingCars racingCars;
    private int round;

    public void play() {
        getInput();
        playAndShowRound();
        printFinalResult();
    }

    private void getInput() {
        this.racingCars = new RacingCars(InputScanner.inputName());
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
        System.out.println("");
    }

    private void printFinalResult() {
        List<RacingCar> winners = this.racingCars.getWinners();
        StringBuilder stringBuilder = new StringBuilder();
        for (RacingCar winner : winners) {
            stringBuilder.append(", ").append(winner.getName());
        }
        stringBuilder.append("가 최종 우승했습니다.");
        stringBuilder.replace(0, 2, "");
        System.out.println(stringBuilder.toString());
    }

}
