package com.nextstep.racingcar.racingcar;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class RacingcarTest {

  private final int MOVE = 4;
  private final int STOP = 0;

  @Test
  void oneCarWins() {
    String[] carNames = new String[]{"losea", "loseb", "win"};
    Racingcar racingcar = new Racingcar(carNames, 3);

    while (racingcar.isInProgress()) {
      racingcar.simulate(Arrays.asList(STOP, STOP, MOVE));
    }

    assertThat(racingcar.getWinners()).isEqualTo(Arrays.asList("win"));
  }

  @Test
  void twoCarWins() {
    String[] carNames = new String[]{"lose", "wina", "winb"};
    Racingcar racingcar = new Racingcar(carNames, 3);

    while (racingcar.isInProgress()) {
      racingcar.simulate(Arrays.asList(STOP, MOVE, MOVE));
    }

    assertThat(racingcar.getWinners()).isEqualTo(Arrays.asList("wina", "winb"));
  }
}
