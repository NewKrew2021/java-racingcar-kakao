package com.nextstep.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingcarTest {

  private Racingcar racingcar;
  private Car tCar;
  private Car iCar;

  @BeforeEach
  void setUp() {
    racingcar = new Racingcar();
    tCar = new Car("t");
    iCar = new Car("i");
  }

  @Test
  void oneCarWins() {
    for (int i = 0; i < 4; i++) {
      tCar.run(4);
    }

    for (int i = 0; i < 3; i++) {
      iCar.run(4);
    }

    addCars();
    assertThat(racingcar.getWinners()).isEqualTo(Arrays.asList("t"));
  }

  @Test
  void twoCarWins() {
    for (int i = 0; i < 4; i++) {
      tCar.run(4);
    }

    for (int i = 0; i < 4; i++) {
      iCar.run(4);
    }

    addCars();
    assertThat(racingcar.getWinners()).isEqualTo(Arrays.asList("t", "i"));
  }

  void addCars() {
    racingcar.addCar(tCar);
    racingcar.addCar(iCar);
  }
}
