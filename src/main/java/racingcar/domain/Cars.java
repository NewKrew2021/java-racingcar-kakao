package racingcar.domain;

import racingcar.text.Text;
import racingcar.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void createCars(List<String> nameList) {
        for (String name : nameList) {
            cars.add(new Car(name));
        }
    }

    public void simulate() {
        for (Car car : cars) {
            car.tryForward(RandomNumberGenerator.getRandomNumber());
        }
    }

    public int getMaxLocation() {
        OptionalInt max = cars.stream().mapToInt(Car::getLocation).max();
        if (max.isPresent()) {
            return max.getAsInt();
        }
        throw new IllegalStateException(Text.ILLEGAL_STATE_NO_CAR);
    }

    public List<String> getMaxNames() {
        final int maxvalue = getMaxLocation();
        return cars.stream()
                .filter(car -> car.isInLocation(maxvalue))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void add(Car car) {
        cars.add(car);
    }

    public int size() {
        return cars.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
