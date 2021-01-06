package com.nextstep.racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CarsTest {

  private Car tCar;
  private Car iCar;

  @Test
  void oneCarWins() {
    tCar = new Car("t", 4);
    iCar = new Car("i", 3);
    Cars cars = new Cars(Arrays.asList(tCar, iCar));
    assertThat(cars.getWinners()).isEqualTo(Arrays.asList("t"));
  }

  @Test
  void twoCarWins() {
    tCar = new Car("t", 4);
    iCar = new Car("i", 4);
    Cars cars = new Cars(Arrays.asList(tCar, iCar));
    assertThat(cars.getWinners()).isEqualTo(Arrays.asList("t", "i"));
  }
}
