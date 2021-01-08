package view;

import domain.Car;

import java.util.List;

public class OutputView {
    public static void printExecResultSentence() {
        System.out.println("실행 결과");
    }

    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getSegment(car.getPosition()));
        }
        System.out.println();
    }

    private static String getSegment(int length) {
        StringBuilder segment = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            segment.append('-');
        }
        return segment.toString();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
