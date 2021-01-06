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

    public List<Car> findWinners() {
        return findSamePositionWith(findWinner());
    }

    private List<Car> findSamePositionWith(Car car) {
        return cars.stream()
                .filter(it -> it.isSamePositionWith(car))
                .collect(Collectors.toList());
    }

    private Car findWinner() {
        Car winner = cars.get(FIRST_CAR_INDEX);
        return cars.stream()
                .reduce(winner, this::findLeadingCar);
    }

    private Car findLeadingCar(Car car1, Car car2) {
        if (car2.isLeading(car1)) {
            return car2;
        }
        return car1;
    }

    public List<Car> getCars() {
        return cars;
    }
}
