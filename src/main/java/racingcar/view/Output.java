package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class Output {
    private static final String ASK_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ASK_GAME_TIME = "시도할 회수는 몇회인가요?";
    private static final String RESULT = "실행 결과";
    private static final String WINNG_MESSGAE = "가 최종 우승했습니다.";
    private static final char PRESENT_STATUS_CHARACTER = '-';

    public static void askCarsName() {
        System.out.println(ASK_CARS_NAME);
    }

    public static void askGameTime() {
        System.out.println(ASK_GAME_TIME);
    }

    public static void printResultStart() {
        System.out.println(RESULT);
    }

    public static void printSimulationResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printLocation(car.getLocation());
            System.out.println();
        }
        System.out.println();
    }

    public static void printLocation(int location) {
        for (int i = 0; i <= location; ++i) {
            System.out.print(PRESENT_STATUS_CHARACTER);
        }
    }

    public static void printWinner(List<String> winners) {
        String joinedWinners = String.join(", ", winners);
        System.out.println(joinedWinners + WINNG_MESSGAE);
    }
}
