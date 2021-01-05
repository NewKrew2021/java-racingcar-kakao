package com.nextstep.racingcar;

import com.nextstep.racingcar.domain.Car;
import com.nextstep.racingcar.domain.CarResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

  private static Car car;

  @BeforeEach
  void setUp() {
    car = new Car("test");
  }

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
    CarResult result = car.run(number); // MOVE, STOP
    assertThat(result).isEqualTo(CarResult.MOVE);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 3})
  void shouldStop(int number) {
    CarResult result = car.run(number);
    assertThat(result).isEqualTo(CarResult.STOP);
  }

  @ParameterizedTest
  @ValueSource(ints = {5, 10})
  void carMoveNTimes(int N) {
    car.run(3);
    for (int i = 0; i < N; i++) {
      car.run(4);
    }
    assertThat(car.getLocation()).isEqualTo(N);
  }
}
