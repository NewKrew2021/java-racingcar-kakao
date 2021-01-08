package racingcar.view;

import racingcar.controller.Racing;

import java.util.Map;
import java.util.stream.IntStream;

public class OutputView {

    public static void printWinnerName(Racing rc) {
        System.out.print(String.join(",", rc.getCars().getWinnerName()));
        System.out.println("가 최종 우승했습니다.");
    }

    public static void printCurrentCarStatus(Racing rc) {
        Map<String, Integer> carsInfo = rc.getCarsInfo();
        carsInfo.forEach((key, value) -> {
            System.out.print(key + " : ");
            printBars(value);
        });
        System.out.println();
    }

    private static void printBars(int number) {
        IntStream.range(0, number).forEach(i -> {
            System.out.print("-");
        });
        System.out.println();
    }
}
