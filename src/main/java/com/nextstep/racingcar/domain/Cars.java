package com.nextstep.racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

  private final List<Car> cars;

  public Cars(String carNames) {
    this(Arrays.stream(carNames.split(","))
        .map(Car::new)
        .collect(Collectors.toList()));
  }

  public Cars(List<Car> cars) {
    this.cars = Collections.unmodifiableList(cars);
    ;
  }

  public CarsInfo race() {
    cars.forEach(car -> car.move(Utils.getRandomInt()));
    return convertToInfo(cars);
  }

  private CarsInfo convertToInfo(List<Car> cars) {
    return new CarsInfo(
        cars.stream()
            .map(car -> new CarInfo(car.getName(), car.getLocation()))
            .collect(Collectors.toList()));
  }

  public List<String> getWinners() {
    int farthestLocation = getFarthestLocation();

    return cars.stream()
        .filter(car -> farthestLocation == car.getLocation())
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
}
