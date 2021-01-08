package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TryNumber;
import racingcar.utils.RandomNumberForRacing;

import java.util.*;
import java.util.stream.Collectors;

public class Racing {

    private Cars cars;
    private TryNumber tryNumber;

    public Racing(String carNames, int tryNumber) {
        createCars(Arrays
                .stream(carNames.split(","))
                .map(s -> s.trim())
                .collect(Collectors.toList()));
        this.tryNumber = new TryNumber(tryNumber);
    }

    public void oneRoundRacing() {
        cars.moveAll(RandomNumberForRacing.getRandomNumberListForRacing(cars.getNumberOfCars()));
        tryNumber.useTryNumber();
    }

    public void createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.cars = new Cars(cars);
    }

    public Cars getCars() {
        return this.cars;
    }

    public boolean canRace() {
        return tryNumber.isLeftTryNumber();
    }

    public Map<String, Integer> getCarsInfo() {
        return cars.getCarsInfo();
    }
}
