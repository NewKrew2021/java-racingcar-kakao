package com.nextstep.racingcar.domain;

import com.nextstep.racingcar.domain.exceptions.OutOfBoundNumberException;

public class Car {

  private static final int MOVE_NUMBER = 4;

  private final CarName name;
  private final CarLocation location;

  public Car(String carName) {
    this(carName, 0);
  }

  public Car(String carName, int location) {
    carName = carName.trim();
    this.name = new CarName(carName);
    this.location = new CarLocation(location);
  }

  public void move(int randomNumber) {
    randomNumberCheck(randomNumber);
    if (carShouldMove(randomNumber)) {
      this.location.move();
    }
  }

  private void randomNumberCheck(int randomNumber) {
    if (randomNumber < 0 || randomNumber > 9) {
      throw new OutOfBoundNumberException("범위를 벗어난 숫자가 입력되었습니다.");
    }
  }

  private boolean carShouldMove(int randomNumber) {
    return randomNumber >= MOVE_NUMBER;
  }

  public int max(int highest) {
    return Math.max(this.location.getLocation(), highest);
  }

  public String getName() {
    return this.name.getName();
  }

  public int getLocation() {
    return this.location.getLocation();
  }
}
