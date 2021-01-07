package com.nextstep.racingcar.domain;

import com.nextstep.racingcar.domain.exceptions.InvalidNameFormatException;
import java.util.Objects;

public class CarName {

  private final String name;

  public CarName(String name) {
    carNameFormatCheck(name);
    this.name = name;
  }

  private void carNameFormatCheck(String carName) {
    if (isNotAllowedName(carName)) {
      throw new InvalidNameFormatException(carName);
    }
  }

  private static boolean isNotAllowedName(String input) {
    return !input.matches("[a-zA-Z]{1,5}");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarName carName = (CarName) o;
    return Objects.equals(name, carName.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  public String getName() {
    return name;
  }
}
