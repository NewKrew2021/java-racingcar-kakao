package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.Scanner;

public class UserView {

    private static final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_ROUND = "시도할 회수는 몇회인가요?";
    private static final String PROCESS_TITLE = "실행 결과";
    private static final String WINNER_MESSAGE = "(이)가 최종 우승했습니다.";
    private static final String STATUS_BAR_STYLE = "-";

    public static String enterCarNames() {
        System.out.println(REQUEST_CAR_NAMES);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int enterRound() {
        System.out.println(REQUEST_ROUND);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void printProcessTitle() {
        System.out.println(PROCESS_TITLE);
    }

    public static void printProcessStatus(List<Car> cars) {
        for (Car car : cars) {
            printCarName(car.getName());
            printStatusBar(car.getPosition());
        }
        newLine();
    }

    public static void printWinnerName(List<String> names) {
        System.out.print(String.join(", ", names));
        System.out.println(WINNER_MESSAGE);
    }

    private static void printCarName(String name) {
        System.out.printf("%-4s : ", name);
    }

    private static void printStatusBar(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(STATUS_BAR_STYLE);
        }
        newLine();
    }

    private static void newLine() {
        System.out.println();
    }
}
