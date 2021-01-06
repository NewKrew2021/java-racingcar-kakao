package racingcar;

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

    public List<Car> getWinners() {

        List<Car> winners = new ArrayList<Car>();
        Collections.sort(cars);
        Car firstPlaceCar = cars.get(0);
        int index = 0;
        while (firstPlaceCar.isEqualPosition(cars.get(index))) {
            winners.add(cars.get(index++));
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
