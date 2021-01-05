package com.nextstep.racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class inputCheckTest {

  @Test
  void invalidCarName() {
    assertThatExceptionOfType(RuntimeException.class).
        isThrownBy(
            () -> InputCheck.isValidName("longname"));

    assertThatExceptionOfType(RuntimeException.class).
        isThrownBy(
            () -> InputCheck.isValidName("na!me"));
  }

  @Test
  void validCarName() {
    assertThat(InputCheck.isValidName("valid")).isTrue();
  }
}
