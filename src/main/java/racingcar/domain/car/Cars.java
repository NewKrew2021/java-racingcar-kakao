package racingcar.domain.car;

import racingcar.domain.game.MovingStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public Cars(List<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.of(carName, 0));
        }
    }

    public void moveCars(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.moveCarPosition(movingStrategy);
        }
    }

    public int maxCarPosition(){
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}
