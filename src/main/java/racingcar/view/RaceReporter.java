package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class RaceReporter {

    public static final String REQUEST_NAME_ANNOUNCE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String REQUEST_TIME_ANNOUNCE = "시도할 회수는 몇회인가요?";
    public static final String DELIMITER = ",";
    public static final String WIN_ANNOUNCE = "가 최종 우승했습니다.";

    public void printRequestName() {
        System.out.println(REQUEST_NAME_ANNOUNCE);
    }

    public void printRequestTime() {
        System.out.println(REQUEST_TIME_ANNOUNCE);
    }

    public void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public void printEnd(List<String> winnerNames) {
        System.out.println(String.join(DELIMITER, winnerNames) + WIN_ANNOUNCE);
    }
}
