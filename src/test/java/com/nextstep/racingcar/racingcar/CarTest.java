package com.nextstep.racingcar.racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

  private final int ONE_UNIT = 1;

  @Test
  void shouldMoveOneUnit() {
    Car car = new Car("test");
    int currentLocation = car.getLocation();

    car.move();

    assertThat(car.getLocation()).isEqualTo(currentLocation + ONE_UNIT);
  }
}
