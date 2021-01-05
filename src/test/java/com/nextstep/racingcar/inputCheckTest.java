package com.nextstep.racingcar;

import com.nextstep.racingcar.domain.InputCheck;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class inputCheckTest {

  @Test
  void invalidCarName() {
    assertThatExceptionOfType(RuntimeException.class).
        isThrownBy(
            () -> {
              InputCheck.checkName("longname");
            });

    assertThatExceptionOfType(RuntimeException.class).
        isThrownBy(
            () -> {
              InputCheck.checkName("na!me");
            });
  }

  @Test
  void validCarName() {
    assertThat(InputCheck.checkName("valid")).isTrue();
  }
}
