package com.nextstep.racingcar.domain;

import com.nextstep.racingcar.domain.exceptions.InvalidNameFormatException;
import com.nextstep.racingcar.domain.exceptions.OutOfBoundNumberException;

public class Car {

  private static final int MOVE_NUMBER = 4;

  private final String name;
  private int location;

  public Car(String carName) {
    this(carName, 0);
  }

  public Car(String carName, int location) {
    carName = carName.trim();
    carNameFormatCheck(carName);
    this.name = carName;
    this.location = location;
  }

  public void move(int randomNumber) {
    randomNumberCheck(randomNumber);
    if (carShouldMove(randomNumber)) {
      this.location += 1;
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

  private void carNameFormatCheck(String carName) {
    if (isNotAllowedName(carName)) {
      throw new InvalidNameFormatException(carName);
    }
  }

  private static boolean isNotAllowedName(String input) {
    return !input.matches("[a-zA-Z]{1,5}");
  }

  public int max(int highest) {
    return Math.max(this.location, highest);
  }

  public String getName() {
    return this.name;
  }

  public int getLocation() {
    return this.location;
  }
}
