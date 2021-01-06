package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> findWinners() {
        int maxLocation = getMaxLocation();
        return cars.stream()
                .filter(c -> isMaxLocation(c,maxLocation))
                .collect(Collectors.toList());

    }

    private int getMaxLocation() {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .getAsInt();
    }

    private boolean isMaxLocation(Car car, int maxLocation){
        return car.getLocation() == maxLocation;
    }
}
