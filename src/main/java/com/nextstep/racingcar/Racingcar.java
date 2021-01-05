package com.nextstep.racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class Racingcar {

  private List<Car> cars;

  public Racingcar() {
    cars = new ArrayList<>();
  }

  public void addCar(Car newCar) {
    cars.add(newCar);
  }

  public void race() {
    cars.forEach(car -> car.run(Utils.getRandomInt()));
  }

  public List<String> getWinners() {
    int highest = getHighestAdvancedCar();

    return cars.stream()
        .filter(car -> isWinner(highest, car))
        .map(Car::getName)
        .collect(Collectors.toList());
  }

  private int getHighestAdvancedCar() {
    Comparator<Car> cmp = Comparator.comparingInt(Car::getLocation);

    return Collections.max(cars, cmp)
        .getLocation();
  }

  private boolean isWinner(int highest, Car car) {
    return highest == car.getLocation();
  }

  public String toString() {
    StringBuilder raceResult = new StringBuilder();
    for (Car car : cars) {
      raceResult.append(car.toString());
    }
    return raceResult.toString();
  }
}
