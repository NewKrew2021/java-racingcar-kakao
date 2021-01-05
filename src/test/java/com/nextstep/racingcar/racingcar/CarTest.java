package com.nextstep.racingcar.racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

  @Test
  void createNewCars() {
    List<Car> cars = new ArrayList<Car>();
    String[] carNames = new String[]{"name", "asd"};
    for (String carName : carNames) {
      cars.add(new Car(carName));
    }

    for (int i = 0; i < carNames.length; i++) {
      assertThat(cars.get(i).getName())
          .isEqualTo(carNames[i]);
    }
  }

  @ParameterizedTest
  @ValueSource(ints = {4, 9})
  void shouldAdvance(int number) {
    Car car = new Car("test");
    CarResult result = car.shouldMove(number); // MOVE, STOP
    assertThat(result).isEqualTo(CarResult.MOVE);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 3})
  void shouldStop(int number) {
    Car car = new Car("test");
    CarResult result = car.shouldMove(number);
    assertThat(result).isEqualTo(CarResult.STOP);
  }

  @ParameterizedTest
  @ValueSource(ints = {5, 10})
  void carMoveNTimes(int N) {
    Car car = new Car("test");
    car.shouldMove(3);
    for (int i = 0; i < N; i++) {
      car.shouldMove(4);
    }
    assertThat(car.getLocation()).isEqualTo(N);
  }
}
