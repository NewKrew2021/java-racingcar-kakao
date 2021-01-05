package com.nextstep.racingcar.racingcar;

public class Car {

  private String name;
  private int location;

  public Car(String carName, int location) {
    this.name = carName;
    this.location = location;
  }

  public void move() {
    this.location += 1;
  }

  public String getName() {
    return this.name;
  }

  public int getLocation() {
    return this.location;
  }
}
