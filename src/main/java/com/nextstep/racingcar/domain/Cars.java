package com.nextstep.racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getNumberOfCars() {
        return cars.size();
    }

    public void move(List<Integer> numbersToCheckMovement) {
        IntStream.range(0, cars.size())
                .filter(i -> moveResult(numbersToCheckMovement.get(i)) == CarResult.MOVE)
                .mapToObj(cars::get)
                .forEach(Car::move);
    }

    public List<Car> getWinners() {
        int highest = getLocationOfHighestAdvancedCar();

        return cars.stream()
                .filter(car -> car.getLocation() == highest)
                .collect(Collectors.toList());
    }

    protected CarResult moveResult(int number) {
        if (isCarAdvance(number)) {
            return CarResult.MOVE;
        }
        return CarResult.STOP;
    }

    protected int getLocationOfHighestAdvancedCar() {
        return cars.stream()
                .max(Comparator.comparing(Car::getLocation))
                .map(Car::getLocation)
                .orElse(0);
    }

    private boolean isCarAdvance(int number) {
        return number >= 4;
    }
}
