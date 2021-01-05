package com.nextstep.racingcar.racingcar;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class RacingcarTest {

  private final int MOVE = 4;
  private final int REPEAT_COUNT = 3;
  private final int STOP = 0;
  private final String[] CAR_NAMES = new String[]{"one", "two", "three"};
  private final Racingcar RACINGCAR = new Racingcar(CAR_NAMES, REPEAT_COUNT);

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
}
