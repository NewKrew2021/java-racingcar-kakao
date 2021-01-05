package com.nextstep.racingcar.domain;

public class Car {

  private static final int MOVE_NUMBER = 4;

  private final String name;
  private int location;

  public Car(String carName) {
    this.name = carName;
    this.location = 0;
  }

  public boolean run(int number) {
    if(number < 0 || number > 9) throw new OutOfBoundNumberException();

    if (carShouldMove(number)) {
      move();
      return true;
    }
    return false;
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
