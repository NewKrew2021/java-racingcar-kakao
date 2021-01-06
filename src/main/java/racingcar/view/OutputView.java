package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printGetName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printGetTime() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResult() {
        System.out.println("\n실행 결과");
    }

    public static void printDistance(List<Car> cars) {
        for (Car car : cars) {
            String distance = new String(new char[car.getDistance()]).replace("\0", "-");
            System.out.println(car.getName() + " : " + distance);
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
