package com.nextstep.racingcar.racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingcarTest {

  private final int REPEAT_COUNT = 3;

  @Test
  void oneCarWins() {
    List<Car> cars = Arrays.asList(
        new Car("one", 0),
        new Car("two", 0),
        new Car("three", 2));
    Racingcar racingcar = new Racingcar(cars, REPEAT_COUNT);
    List<String> winners = racingcar.getWinners()
        .stream()
        .map(Car::getName)
        .collect(Collectors.toList());

    assertThat(winners).isEqualTo(Arrays.asList("three"));
  }

  @Test
  void twoCarWins() {
    List<Car> cars = Arrays.asList(
        new Car("one", 0),
        new Car("two", 2),
        new Car("three", 2));
    Racingcar racingcar = new Racingcar(cars, REPEAT_COUNT);
    List<String> winners = racingcar.getWinners()
        .stream()
        .map(Car::getName)
        .collect(Collectors.toList());

    assertThat(winners).isEqualTo(Arrays.asList("two", "three"));
  }

  @ParameterizedTest
  @CsvSource({"2,true", "3,false"})
  void checkFinished(int simulateCount, boolean expected) {
    List<Car> cars = Arrays.asList(
        new Car("one", 0),
        new Car("two", 0),
        new Car("three", 0));
    Racingcar racingcar = new Racingcar(cars, REPEAT_COUNT);

    for (int i = 0; i < simulateCount; i++) {
      racingcar.simulate();
    }

    assertThat(racingcar.isInProgress()).isEqualTo(expected);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 3})
  void shouldStop(int value) {
    List<Car> cars = Arrays.asList(
        new Car("one", 0),
        new Car("two", 0),
        new Car("three", 0));
    Racingcar racingcar = new Racingcar(cars, REPEAT_COUNT);

    assertThat(racingcar.moveResult(value)).isEqualTo(CarResult.STOP);
  }

  @ParameterizedTest
  @ValueSource(ints = {4, 9})
  void shouldMove(int value) {
    List<Car> cars = Arrays.asList(
        new Car("one", 0),
        new Car("two", 0),
        new Car("three", 0));
    Racingcar racingcar = new Racingcar(cars, REPEAT_COUNT);

    assertThat(racingcar.moveResult(value)).isEqualTo(CarResult.MOVE);
  }
}
