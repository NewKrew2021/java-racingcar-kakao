package com.nextstep.racingcar;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingcarTest {

  @Test
  void oneCarWins() {
    Racingcar racingcar = new Racingcar();
    Car tCar = new Car("t");
    Car iCar = new Car("i");

    for (int i = 0; i < 4; i++) {
      tCar.shouldMove(4);
    }

    for (int i = 0; i < 3; i++) {
      iCar.shouldMove(4);
    }

    racingcar.addCar(tCar);
    racingcar.addCar(iCar);

    assertThat(racingcar.result()).isEqualTo(Arrays.asList("t"));
  }

  @Test
  void twoCarWins() {
    Racingcar racingcar = new Racingcar();
    Car tCar = new Car("t");
    Car iCar = new Car("i");

    for (int i = 0; i < 4; i++) {
      tCar.shouldMove(4);
    }

    for (int i = 0; i < 4; i++) {
      iCar.shouldMove(4);
    }

    racingcar.addCar(tCar);
    racingcar.addCar(iCar);

    assertThat(racingcar.result()).isEqualTo(Arrays.asList("t", "i"));
  }
}
