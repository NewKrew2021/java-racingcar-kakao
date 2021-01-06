package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class GameView {

    public void roundResult(List<Car> cars) {

        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public void gameResult(List<Car> winners) {

        System.out.println(convertCarName(winners) + "가 최종 우승했습니다.");
    }

    public String convertCarName(List<Car> winners) {

        return winners.stream()
                      .map(Car::getName)
                      .collect(Collectors.joining(", "));
    }

    public void print(String statement) {

        System.out.println(statement);
    }


}
