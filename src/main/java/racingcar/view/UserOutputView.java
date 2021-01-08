package racingcar.view;

import racingcar.domain.Car;

import java.util.Collections;
import java.util.List;

public class UserOutputView {

    private static final String PROCESS_TITLE = "실행 결과";
    private static final String WINNER_MESSAGE = "(이)가 최종 우승했습니다.";
    private static final String STATUS_BAR_STYLE = "-";

    public static void printProcessTitle() {
        System.out.println(PROCESS_TITLE);
    }

    public static void printProcessStatus(List<Car> cars) {
        for (Car car : cars) {
            printCarName(car.getName());
            printStatusBar(car.getPosition());
        }
        System.out.println();
    }

    public static void printWinnerName(List<String> names) {
        System.out.print(String.join(", ", names));
        System.out.println(WINNER_MESSAGE);
    }

    private static void printCarName(String name) {
        System.out.printf("%-4s : ", name);
    }

    private static void printStatusBar(int number) {
        System.out.println(String.join("", Collections.nCopies(number, STATUS_BAR_STYLE)));
    }
}
