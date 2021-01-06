package racingcar.utils;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Racing;

import java.util.stream.IntStream;

public class OutputView {

    public static void printWinnerName(Racing rc) {
        System.out.print(String.join(",", rc.getCars().getWinnerName()));
        System.out.println("가 최종 우승했습니다.");
    }

    public static void printCurrentCarStatus(Racing rc) {
        for (Car car : rc.getCars().getCarsList()) {
            System.out.print(car.getName() + " : ");
            printBars(car.getPosition());
        }
        System.out.println();
    }

    private static void printBars(int number) {
        IntStream.range(0, number).forEach(i -> {
            System.out.print("-");
        });
        System.out.println();
    }
}
