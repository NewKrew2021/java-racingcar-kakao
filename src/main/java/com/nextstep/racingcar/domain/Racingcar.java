package com.nextstep.racingcar.domain;

import static com.nextstep.racingcar.utils.RandomDigitsGenerator.getNRandomDigitsForCars;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racingcar {

  private List<Car> cars;
  private int repeatCount;
  private int currentStep;

  public Racingcar(List<Car> cars, int repeatCount) {
    this.cars = cars;
    this.repeatCount = repeatCount;
    this.currentStep = 0;
  }

  public List<Car> getCars() {
    return cars;
  }

  public List<Car> getWinners() {
    int highest = getLocationOfHighestAdvancedCar();

    return cars.stream()
        .filter(car -> car.getLocation() == highest)
        .collect(Collectors.toList());
  }

  public void simulate() {
    List<Integer> randoms = getNRandomDigitsForCars(cars.size());

    IntStream.range(0, cars.size())
        .filter(i -> moveResult(randoms.get(i)) == CarResult.MOVE)
        .mapToObj(i -> cars.get(i))
        .forEach(Car::move);

    increaseStep();
  }

  public boolean isInProgress() {
    return currentStep < repeatCount;
  }

  private int getLocationOfHighestAdvancedCar() {
    return cars.stream()
        .max(Comparator.comparing(Car::getLocation))
        .map(Car::getLocation)
        .orElse(0);
  }

  private void increaseStep() {
    currentStep++;
  }

  CarResult moveResult(int number) {
    if (isCarAdvance(number)) {
      return CarResult.MOVE;
    }
    return CarResult.STOP;
  }

  private boolean isCarAdvance(int number) {
    return number >= 4;
  }
}
