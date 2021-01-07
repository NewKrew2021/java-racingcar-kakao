package com.nextstep.racingcar.domain;

public class CarInfo {

  private final String name;
  private final int location;

  public CarInfo(String name, int location) {
    this.name = name;
    this.location = location;
  }

  public String getName() {
    return name;
  }

  public int getLocation() {
    return location;
  }
}
