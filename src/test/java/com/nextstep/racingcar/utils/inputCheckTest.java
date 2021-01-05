package com.nextstep.racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class inputCheckTest {

  @ParameterizedTest
  @ValueSource(strings = {"na!me", "nam3", ""})
  void invalidCarName(String name) {
    assertThatExceptionOfType(RuntimeException.class).
        isThrownBy(() -> InputCheck.isValidName(name));
  }

  @Test
  void validCarName() {
    assertThat(InputCheck.isValidName("valid")).isTrue();
  }
}
