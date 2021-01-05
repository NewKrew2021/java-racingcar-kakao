package com.nextstep.racingcar.domain;

public class Car {

  private static final int MOVE_NUMBER = 4;

  private final String name;
  private int location;

  public Car(String carName) {
    this.name = carName;
    this.location = 0;
  }

  public CarResult run(int number) {
    if (carShouldMove(number)) {
      move();
      return CarResult.MOVE;
    }
    return CarResult.STOP;
  }

  private void move() {
    this.location += 1;
  }

  private boolean carShouldMove(int number) {
    return number >= MOVE_NUMBER;
  }

  public String getName() {
    return this.name;
  }

  public int getLocation() {
    return this.location;
  }

  public String toString() {
    return String.format("%s : %s\n", name, "-".repeat(location));
  }
}
