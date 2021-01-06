package com.nextstep.racingcar.domain;

public class Car {

  private String name;
  private int location;

  public Car(String carName, int location) {
    if (isAboveFiveLetters(carName)) {
      throw new RuntimeException("Car cannot handle a name larger than 5");
    }

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

  private boolean isAboveFiveLetters(String name) {
    return name.length() > 5;
  }
}
