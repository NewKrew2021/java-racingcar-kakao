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
        racingCars = new RacingCars(InputScanner.scanName());
        round = InputScanner.scanRound();
    }

    private void playAndShowRound() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < round; i++) {
            racingCars.run();
            printRoundResult();
        }
    }

    private void printRoundResult() {
        racingCars.printRoundResult();
        System.out.println("");
    }

    private void printFinalResult() {
        List<RacingCar> winners = racingCars.getWinners();
        StringBuilder stringBuilder = new StringBuilder();
        for (RacingCar winner : winners) {
            stringBuilder.append(", ").append(winner.getName());
        }
        stringBuilder.append("가 최종 우승했습니다.");
        stringBuilder.replace(0, 2, "");
        System.out.println(stringBuilder.toString());
    }

}
