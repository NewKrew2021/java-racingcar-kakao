package com.nextstep.racingcar;

import org.junit.jupiter.api.Test;

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
}
