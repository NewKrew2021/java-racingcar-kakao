package com.nextstep.racingcar.racingcar;

public class Car {

  private String name;
  private int location;

  public Car(String carName) {
    this.name = carName;
    this.location = 0;
  }

  public CarResult shouldMove(int number) {
    if (carShouldAdvance(number)) {
      move();
      return CarResult.MOVE;
    }
    return CarResult.STOP;
  }

  private void move() {
    this.location += 1;
  }

  private boolean carShouldAdvance(int number) {
    return number >= 4;
  }

  public String getName() {
    return this.name;
  }

  public int getLocation() {
    return this.location;
  }
}
