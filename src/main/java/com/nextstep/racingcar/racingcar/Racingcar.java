package com.nextstep.racingcar.racingcar;

import java.util.*;

public class Racingcar {

  private List<Car> cars;
  private List<String> winners;

  public Racingcar() {
    cars = new ArrayList<>();
    winners = new ArrayList<>();
  }

  public void addCar(Car newCar) {
    cars.add(newCar);
  }

  public List<String> result() {
    int highest = cars.stream()
        .max(Comparator.comparing(num -> num.getLocation()))
        .get()
        .getLocation();

    for (Car car : cars) {
      appendIfWinner(highest, car);
    }
    return winners;
  }

  private void appendIfWinner(int highest, Car car) {
    if (isWinner(highest, car)) {
      winners.add(car.getName());
    }
  }

  private boolean isWinner(int highest, Car car) {
    return highest == car.getLocation();
  }
}
