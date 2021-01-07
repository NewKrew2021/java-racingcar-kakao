package racingcar.domain;

import racingcar.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {

        for (Car car : cars) {
            car.goForward(RandomUtil.getRandomValue());
        }
    }

    public List<String> getWinners() {

        List<String> winners = new ArrayList<>();
        Collections.sort(cars);
        Car firstPlaceCar = cars.get(0);
        int index = 0;
        while (index < cars.size() && firstPlaceCar.isEqualPosition(cars.get(index))) {
            winners.add(cars.get(index++).getName().toString());
        }
        return winners;
    }


    @Override
    public String toString() {

        String result = new String();
        for (Car car : cars) {
            result += car.toString() + "\n";
        }

        return result;
    }


}
