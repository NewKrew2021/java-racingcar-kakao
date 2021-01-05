package com.nextstep.racingcar.racingcar;

public class Car {

  private String name;
  private int location;

  public Car(String carName) {
    this.name = carName;
    this.location = 0;
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
