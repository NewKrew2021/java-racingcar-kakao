package com.nextstep.racingcar.domain;

import com.nextstep.racingcar.domain.exceptions.OutOfBoundNumberException;
import java.util.Objects;

public class CarLocation {

  private int location;

  public CarLocation() {
    this(0);
  }

  public CarLocation(int location) {
    if (location < 0) {
      throw new OutOfBoundNumberException("CarLocation은 음수로 생성될 수 없습니다.");
    }
    this.location = location;
  }

  public void move() {
    this.location += 1;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarLocation that = (CarLocation) o;
    return location == that.location;
  }

  @Override
  public int hashCode() {
    return Objects.hash(location);
  }

  public int getLocation() {
    return location;
  }
}
