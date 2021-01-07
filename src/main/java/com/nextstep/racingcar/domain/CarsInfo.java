package com.nextstep.racingcar.domain;

import java.util.List;

public class CarsInfo {

  private final List<CarInfo> cars;

  public CarsInfo(List<CarInfo> cars) {
    this.cars = cars;
  }

  public List<CarInfo> getCars() {
    return cars;
  }
}
