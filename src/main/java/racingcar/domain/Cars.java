package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final int UPPER_BOUND = 10;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(Utils.getRandomNo(UPPER_BOUND));
        }
    }

    public String getCarsStatus() {
        String carsStatus = "";
        for (Car car : cars) {
            carsStatus += car.getStatus() + "\n";
        }
        return carsStatus;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxLocation() {
        return cars.stream().mapToInt(Car::getLocation).max().getAsInt();
    }

    public ArrayList<String> getCarNamesLocatedIn(int location) {
        List<String> names = cars.stream().filter(car -> car.getLocation() == location).map(Car::getName).collect(Collectors.toList());
        return new ArrayList<>(names);
    }
}
