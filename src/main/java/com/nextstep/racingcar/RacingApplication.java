package com.nextstep.racingcar;

import com.nextstep.racingcar.domain.Cars;
import com.nextstep.racingcar.domain.CarsInfo;
import com.nextstep.racingcar.view.RacingInputView;
import com.nextstep.racingcar.view.RacingResultView;

public class RacingApplication {

  public static void main(String[] args) {
    String carNames = RacingInputView.inputCarNames();
    Cars cars = new Cars(carNames);
    runRacing(cars);
    finishRacing(cars);
  }

  private static void runRacing(Cars cars) {
    int repetitionCount = RacingInputView.inputRepetitionCount();
    CarsInfo carsInfo;

    RacingResultView.printRaceResultMessage();
    for (int i = 0; i < repetitionCount; i++) {
      carsInfo = cars.race();
      RacingResultView.printCars(carsInfo);
    }
  }

  private static void finishRacing(Cars cars) {
    RacingResultView.printWinners(cars.getWinners());
  }
}
