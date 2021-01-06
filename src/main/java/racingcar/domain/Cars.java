package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String[] names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> findWinners() {
        int maxLocation = getMaxLocation();
        return this.cars.stream()
                .filter(c -> isMaxLocation(c, maxLocation))
                .collect(Collectors.toList());

    }

    private int getMaxLocation() {
        return this.cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .getAsInt();
    }

    private boolean isMaxLocation(Car car, int maxLocation) {
        return car.getLocation() == maxLocation;
    }

    public void moveCars(int randomNo) {
        for (Car car : cars) {
            car.move(randomNo);
        }
    }
}
