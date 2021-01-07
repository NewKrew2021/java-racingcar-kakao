package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final char DISTANCE_SYMBOL = '-';

    public static void printResult() {
        System.out.println("\n실행 결과");
    }

    public static void printDistance(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + " : ");
            IntStream.range(0, car.getDistance())
                    .forEach(t -> System.out.print(DISTANCE_SYMBOL));
            System.out.println();
        }

        System.out.println();
    }

    public static void printWinner(List<Car> winners) {
        String winnerString = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(winnerString + "가 최종 우승했습니다.");
    }
}
