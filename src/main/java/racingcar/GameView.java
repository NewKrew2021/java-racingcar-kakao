package racingcar;

import java.util.List;

public class GameView {

    public void roundResult(List<Car> cars) {

        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public void gameResult(List<Car> winners) {

        for (int i = 0; i < winners.size(); i++) {
            System.out.print(convertCarName(winners, i));
        }
        System.out.println("가 최종 우승했습니다.");
    }

    public String convertCarName(List<Car> winners, int index) {

        String name = winners.get(index).getName();
        if (index == winners.size() - 1) {
            return name;
        }
        return name + ", ";
    }

    public void print(String statement) {

        System.out.println(statement);
    }


}
