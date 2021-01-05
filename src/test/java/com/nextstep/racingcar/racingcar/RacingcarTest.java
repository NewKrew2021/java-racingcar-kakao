package com.nextstep.racingcar.racingcar;

import java.util.List;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RacingcarTest {

  private final int MOVE = 4;
  private final int REPEAT_COUNT = 3;
  private final int STOP = 0;
  private final List<Car> CARS = Arrays.asList(
      new Car("one"),
      new Car("two"),
      new Car("three"));
  private final Racingcar RACINGCAR = new Racingcar(CARS, REPEAT_COUNT);

  @Test
  void oneCarWins() {
    while (RACINGCAR.isInProgress()) {
      RACINGCAR.simulate(Arrays.asList(STOP, STOP, MOVE));
    }

    assertThat(RACINGCAR.getWinners()).isEqualTo(Arrays.asList("three"));
  }

  @Test
  void twoCarWins() {
    while (RACINGCAR.isInProgress()) {
      RACINGCAR.simulate(Arrays.asList(STOP, MOVE, MOVE));
    }

    assertThat(RACINGCAR.getWinners()).isEqualTo(Arrays.asList("two", "three"));
  }

  @ParameterizedTest
  @CsvSource({"2,true", "3,false"})
  void checkFinished(int simulateCount, boolean expected) {
    for (int i = 0; i < simulateCount; i++) {
      RACINGCAR.simulate(Arrays.asList(STOP, STOP, STOP));
    }

    assertThat(RACINGCAR.isInProgress()).isEqualTo(expected);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 3})
  void shouldMove(int value) {
    assertThat(RACINGCAR.moveResult(value)).isEqualTo(CarResult.MOVE);
  }

  @ParameterizedTest
  @ValueSource(ints = {4, 9})
  void shouldStop(int value) {
    assertThat(RACINGCAR.moveResult(value)).isEqualTo(CarResult.STOP);
  }
}
