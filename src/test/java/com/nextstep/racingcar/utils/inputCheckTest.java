package com.nextstep.racingcar.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class inputCheckTest {

  @ParameterizedTest
  @ValueSource(strings = {"longname", "na!me", "nam3"})
  void invalidCarName(String name) {
    assertThatExceptionOfType(RuntimeException.class).
        isThrownBy(
            () -> InputCheck.isValidName(name));
  }

  @Test
  void validCarName() {
    assertThat(InputCheck.isValidName("valid")).isTrue();
  }
}
