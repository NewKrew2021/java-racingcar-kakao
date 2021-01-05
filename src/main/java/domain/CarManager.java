package domain;

import util.NumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarManager {
    private final List<Car> cars = new ArrayList<>();

    public void pushCar(Car car) {
        cars.add(car);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveOrNot(NumberUtil.generateRandomNumber());
        }
    }

    public List<Car> findWinnerCars() {
        Car winner = findWinnerCar();

        return cars.stream()
                .filter(car -> car.isSamePositionWith(winner))
                .collect(Collectors.toList());
    }

    private Car findWinnerCar() {
        Car maxPositionCar = cars.get(0);

        return cars.stream()
                .reduce(maxPositionCar, this::findForwardingCarBetween);
    }

    private Car findForwardingCarBetween(Car car1, Car car2) {
        if (car2.isForwardThan(car1)) {
            return car2;
        }
        return car1;
    }

    public List<Car> getCars() {
        return cars;
    }

}
