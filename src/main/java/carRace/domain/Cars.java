package carRace.domain;

import carRace.strategy.MovingStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = Collections.unmodifiableList(carList);
    }

    public static Cars fromNames(String[] names) {
        List<Car> newCars = new ArrayList<>();
        for (String name : names) {
            newCars.add(Car.of(name));
        }
        return new Cars(newCars);
    }

    public void moveAllCars(MovingStrategy strategy) {
        carList.forEach(car -> {
            car.go(strategy);
        });
    }

    public List<Car> getWinners() {
        Car maxCar = Collections.max(carList);
        return carList.stream()
                .filter(car -> car.compareTo(maxCar) == 0)
                .collect(Collectors.toList());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car).append("\n");
        }
        return sb.toString();
    }
}
