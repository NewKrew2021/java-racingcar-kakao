package com.nextstep.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.nextstep.racingcar.domain.exceptions.InvalidNameFormatException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

  @ParameterizedTest
  @ValueSource(strings = {"a", "abcde"})
  void create(String name) {
    CarName carName = new CarName(name);
    assertThat(carName).isEqualTo(new CarName(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"", " ", "longname", "!abc", "car12"})
  void invalidName(String name) {
    assertThatExceptionOfType(InvalidNameFormatException.class)
        .isThrownBy(() -> new CarName(name));
  }
}
