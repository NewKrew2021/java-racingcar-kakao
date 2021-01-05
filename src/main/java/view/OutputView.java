package view;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();

    public static void printCars(List<Car> cars) {
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            sb.append(car.getName()).append(" : ");
            appendDistance(sb, car);
            sb.append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }

    private static void appendDistance(StringBuilder sb, Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }
    }

    public static void printWinnerCars(List<Car> winnerCars) {
        String winnerCarNames = winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerCarNames + "가 최종 우승했습니다.");
    }
}
