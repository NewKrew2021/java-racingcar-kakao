package com.nextstep.racingcar.racingcar;

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

  public List<String> getWinners() {
    int highest = getLocationOfHighestAdvancedCar();

    return cars.stream()
        .filter(car -> car.getLocation() == highest)
        .map(Car::getName)
        .collect(Collectors.toList());
  }

  public void simulate(List<Integer> customRandom) {
    simulateOnce(customRandom);
  }

  public void simulate() {
    List<Integer> randoms = getNRandomDigitsForCars(cars.size());
    simulateOnce(randoms);
  }

  public boolean isInProgress() {
    return currentStep < repeatCount;
  }

  private void simulateOnce(List<Integer> randoms) {
    IntStream.range(0, cars.size())
        .filter(i -> moveResult(randoms.get(i)) == CarResult.MOVE)
        .mapToObj(i -> cars.get(i))
        .forEach(Car::move);

    increaseCounter();
  }

  private int getLocationOfHighestAdvancedCar() {
    return cars.stream()
        .max(Comparator.comparing(Car::getLocation))
        .map(Car::getLocation)
        .orElse(0);
  }

  private void increaseCounter() {
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
