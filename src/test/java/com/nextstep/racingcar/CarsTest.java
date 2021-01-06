package com.nextstep.racingcar;

import com.nextstep.racingcar.domain.Car;
import com.nextstep.racingcar.domain.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {

  private Cars cars;
  private Car tCar;
  private Car iCar;

  @BeforeEach
  void setUp() {
    cars = new Cars();
  }

  @Test
  void oneCarWins() {
    tCar = new Car("t", 4);
    iCar = new Car("i", 3);
    addCars();
    assertThat(cars.getWinners()).isEqualTo(Arrays.asList("t"));
  }

  @Test
  void twoCarWins() {
    tCar = new Car("t", 4);
    iCar = new Car("i", 4);
    addCars();
    assertThat(cars.getWinners()).isEqualTo(Arrays.asList("t", "i"));
  }

  void addCars() {
    cars.addCar(tCar);
    cars.addCar(iCar);
  }
}
