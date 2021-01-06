package com.nextstep.racingcar;

import com.nextstep.racingcar.domain.Car;
import com.nextstep.racingcar.domain.exceptions.OutOfBoundNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarTest {

  private static Car car;

  @BeforeEach
  void setUp() {
    car = new Car("test");
  }

  @Test
  void validCarName() {
    assertThat(new Car("valid").getName()).isEqualTo("valid");
  }

  @Test
  void invalidCarName() {
    assertThatExceptionOfType(RuntimeException.class).
        isThrownBy(
            () -> {
              new Car("longname");
            });

    assertThatExceptionOfType(RuntimeException.class).
        isThrownBy(
            () -> {
              new Car("na!me");
            });
  }

  @ParameterizedTest
  @ValueSource(ints = {4, 9})
  void move(int number) {
    car.move(number); // MOVE, STOP
    assertThat(car.getLocation()).isEqualTo(1);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 3})
  void stop(int number) {
    car.move(number);
    assertThat(car.getLocation()).isEqualTo(0);
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, 10})
  void exception(int number) {
    assertThatExceptionOfType(OutOfBoundNumberException.class).
        isThrownBy(
            () -> {
              car.move(number);
            });
  }

  @ParameterizedTest
  @ValueSource(ints = {5, 10})
  void carMoveNTimes(int N) {
    car.move(3);
    for (int i = 0; i < N; i++) {
      car.move(4);
    }
    assertThat(car.getLocation()).isEqualTo(N);
  }
}
