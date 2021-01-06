package com.nextstep.racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

  private List<Car> cars;

  public Cars() {
    cars = new ArrayList<>();
  }

  public void addCar(Car newCar) {
    cars.add(newCar);
  }

  public void race() {
    cars.forEach(car -> car.move(Utils.getRandomInt()));
  }

  public List<String> getWinners() {
    int farthestLocation = getFarthestLocation();

    return cars.stream()
        .filter(car -> isWinner(farthestLocation, car))
        .map(Car::getName)
        .collect(Collectors.toList());
  }

  private int getFarthestLocation() {
    int farthestLocation = 0;
    for (Car car: cars) {
      farthestLocation = car.max(farthestLocation);
    }

    return farthestLocation;
  }

  private boolean isWinner(int farthestLocation, Car car) {
    return farthestLocation == car.getLocation();
  }

  public List<Car> getCars() {
    return cars;
  }
}
