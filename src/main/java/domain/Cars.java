package domain;

import utils.CustomRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            cars.add(new Car(carName));
        }
        this.cars = cars;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void play() {
        for (Car car : cars) {
            car.runWithCondition(CustomRandom.nextInt());
        }
    }
}
