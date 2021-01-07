package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.Winners;

import java.util.ArrayList;

public class ResultPrinter {

    private ResultPrinter() {
        throw new IllegalStateException("Utility Class");
    }

    public static void printResultWord() {
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(RacingCars racingCars) {
        racingCars.getRacingCars().stream().forEach(racingCar -> printEachRacingCarResult(racingCar));
        System.out.println();
    }

    public static void printFinalResult(Winners winners) {
        ArrayList winnerNames = new ArrayList<>();
        for (RacingCar winner : winners.getWinners()) {
            winnerNames.add(winner.getName().getName());
        }
        System.out.print(String.join(", ", winnerNames));
        System.out.println("가 최종 우승했습니다.");
    }

    private static void printEachRacingCarResult(RacingCar racingCar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(racingCar.getName().getName()).append(" : ");
        for (int i = 0; i < racingCar.getDistance().getDistance(); i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());
    }

}
