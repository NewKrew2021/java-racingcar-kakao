package com.nextstep.racingcar.domain;

import java.util.*;
import java.util.function.Consumer;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        if (hasDuplicatedCar(cars)) {
            String message = "There can be no cars with same name";
            throw new IllegalArgumentException(message);
        }

        this.cars = Collections.unmodifiableList(cars);
    }

    public void delegate(Consumer<Car> consumer) {
        cars.forEach(consumer);
    }

    public void move(MovingStrategy strategy) {
        cars.forEach(car -> {
            if (strategy.isMove()) {
                car.move();
            }
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars that = (Cars) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    protected int getLocationOfHighestAdvancedCar() {
        return cars.stream()
                .max(Comparator.comparing(Car::getLocation))
                .map(Car::getLocation)
                .orElse(0);
    }

    private boolean hasDuplicatedCar(List<Car> cars) {
        int originalCarNum = cars.size();

        return cars.stream()
                .distinct()
                .count() != originalCarNum;
    }
}
