package view;

import domain.Car;

import java.util.Collections;
import java.util.List;

public final class ResultView {
    private static final String HYPHEN = "-";

    public static void printProgress(List<Car> cars){
        for (Car car : cars) {
            String text = car.getName() + " : " + repeat(car.getPosition(), HYPHEN);
            System.out.println(text);
        }
        System.out.println();
    }

    public static void printHeader() {
        System.out.println("\n실행결과");
    }

    public static void printWinners(List<String> winners) {
        String text = String.join(", ", winners);
        System.out.println(text + "가 최종 우승했습니다.");
    }

    private static String repeat(int n, String str) {
        return String.join("", Collections.nCopies(n, str));
    }
}
