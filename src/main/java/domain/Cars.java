package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int FIRST_CAR_INDEX = 0;

    private final List<Car> cars;

    Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public static Cars create(Engine engine, List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(name -> new Car(engine, name))
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.tryMoving();
        }
    }

    public List<Car> findWinnerCars() {
        Car winner = findWinnerCar();
        return cars.stream()
                .filter(car -> car.isSamePositionWith(winner))
                .collect(Collectors.toList());
    }

    private Car findWinnerCar() {
        Car winner = cars.get(FIRST_CAR_INDEX);
        return cars.stream()
                .reduce(winner, this::findForwardingCar);
    }

    private Car findForwardingCar(Car car1, Car car2) {
        if (car2.isForwardThan(car1)) {
            return car2;
        }
        return car1;
    }

    public List<Car> getCars() {
        return cars;
    }
}
