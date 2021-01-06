package com.nextstep.racingcar.domain;

import static com.nextstep.racingcar.utils.RandomDigitsGenerator.getNRandomDigitsForCars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

  private final String CAR_UNIT_STEP_SYMBOL = "-";

  private final List<Car> cars;

  public Cars() {
    this.cars = new ArrayList<>();
  }

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public int getNumberOfCars() {
    return cars.size();
  }

  public void move() {
    List<Integer> randoms = getNRandomDigitsForCars(getNumberOfCars());

    IntStream.range(0, cars.size())
        .filter(i -> moveResult(randoms.get(i)) == CarResult.MOVE)
        .mapToObj(cars::get)
        .forEach(Car::move);
  }

  public Cars getWinners() {
    int highest = getLocationOfHighestAdvancedCar();

    return new Cars(cars.stream()
        .filter(car -> car.getLocation() == highest)
        .collect(Collectors.toList()));
  }

  public List<String> filterOnlyNames() {
    return cars.stream()
        .map(Car::getName)
        .collect(Collectors.toList());
  }

  public String getNamesAppended() {
    return cars.stream()
        .map(Car::getName)
        .collect(Collectors.joining(", "));
  }

  public String getCarsStatus() {
    StringBuilder status = new StringBuilder();

    for (Car car : cars) {
      status.append(car.getName())
          .append(" : ")
          .append(String.join("",
              Collections.nCopies(car.getLocation(), CAR_UNIT_STEP_SYMBOL)))
          .append(System.lineSeparator());
    }

    return status.toString();
  }

  protected CarResult moveResult(int number) {
    if (isCarAdvance(number)) {
      return CarResult.MOVE;
    }
    return CarResult.STOP;
  }

  private boolean isCarAdvance(int number) {
    return number >= 4;
  }

  private int getLocationOfHighestAdvancedCar() {
    return cars.stream()
        .max(Comparator.comparing(Car::getLocation))
        .map(Car::getLocation)
        .orElse(0);
  }
}