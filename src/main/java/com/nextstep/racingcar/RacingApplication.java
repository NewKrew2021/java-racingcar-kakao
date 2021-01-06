package com.nextstep.racingcar;

import com.nextstep.racingcar.domain.Car;
import com.nextstep.racingcar.domain.Cars;
import com.nextstep.racingcar.view.RacingInputView;
import com.nextstep.racingcar.view.RacingResultView;

public class RacingApplication {

  public static void main(String[] args) {
    String carNames = RacingInputView.inputCarNames();
    Cars cars = createCars(carNames);
    runRacing(cars);
    finishRacing(cars);
  }

  private static Cars createCars(String carNames) {
    Cars cars = new Cars();
    for (String carName: carNames.split(",")) {
      cars.addCar(new Car(carName));
    }

    return cars;
  }

  private static void runRacing(Cars cars) {
    int repetitionCount = RacingInputView.inputRepetitionCount();

    RacingResultView.printRaceResultMessage();
    for (int i = 0; i < repetitionCount; i++) {
      cars.race();
      RacingResultView.printCars(cars);
    }
  }

  private static void finishRacing(Cars cars) {
    RacingResultView.printWinners(cars);
  }
}
