package com.nextstep.racingcar.racingcar;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racingcar {

  private List<Car> cars;
  private int repeatCount;
  private int currentStep;

  public Racingcar(String[] carNames, int repeatCount) {
    cars = new ArrayList<>();
    this.repeatCount = repeatCount;
    this.currentStep = 0;

    addCarsWithNames(carNames);
  }

  public List<String> getWinners() {
    int highest = getHighestAdvancedCar();

    return cars.stream()
        .filter(car -> car.getLocation() == highest)
        .map(Car::getName)
        .collect(Collectors.toList());
  }

  public void simulateOnce(List<Integer> customRandom) {
    simulate(customRandom);
  }

  public void simulateOnce() {
    List<Integer> randoms = getRandomDigitsForCars();
    simulate(randoms);
  }

  private void simulate(List<Integer> randoms) {
    IntStream.range(0, cars.size())
        .filter(i -> moveResult(randoms.get(i)) == CarResult.MOVE)
        .mapToObj(i -> cars.get(i))
        .forEach(Car::move);

    increaseCounter();
  }

  public boolean isFinished() {
    return repeatCount <= currentStep;
  }

  private void addCarsWithNames(String[] carNames) {
    for (String carName : carNames) {
      addCarWithName(carName);
    }
  }

  private void addCarWithName(String carName) {
    cars.add(new Car(carName));
  }

  private int getHighestAdvancedCar() {
    return cars.stream()
        .max(Comparator.comparing(Car::getLocation))
        .map(Car::getLocation)
        .orElse(0);
  }

  private List<Integer> getRandomDigitsForCars() {
    return new Random()
        .ints(cars.size())
        .boxed()
        .map(n -> n % 10)
        .collect(Collectors.toList());
  }

  private void increaseCounter() {
    currentStep++;
  }

  private CarResult moveResult(int number) {
    if (isCarAdvance(number)) {
      return CarResult.MOVE;
    }
    return CarResult.STOP;
  }

  private boolean isCarAdvance(int number) {
    return number >= 4;
  }
}
