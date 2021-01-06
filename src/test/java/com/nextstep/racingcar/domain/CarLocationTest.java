package com.nextstep.racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import com.nextstep.racingcar.domain.exceptions.OutOfBoundNumberException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarLocationTest {

  @ParameterizedTest
  @ValueSource(ints = {0, 9999})
  void create(int location) {
    CarLocation carLocation = new CarLocation(location);
    assertThat(carLocation).isEqualTo(new CarLocation(location));
  }

  @Test
  void create_init_0() {
    CarLocation carLocation = new CarLocation();
    assertThat(carLocation).isEqualTo(new CarLocation(0));
  }

  @Test
  void invalid() {
    assertThatExceptionOfType(OutOfBoundNumberException.class)
        .isThrownBy(() -> new CarLocation(-1));
  }
}
