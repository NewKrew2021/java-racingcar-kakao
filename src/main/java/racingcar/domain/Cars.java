package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int INITIAL_DISTANCE = 0;
    private final List<Car> cars;

    public Cars(String input) {
        cars = new ArrayList<>();
        String[] names = input.split(",");

        for (String name : names) {
            cars.add(new Car(name, INITIAL_DISTANCE));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveAll(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }

    public List<Car> getWinners() {
        int maxDistance = getMaxDistance();

        return cars.stream()
                .filter(o1 -> o1.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    public int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
}
