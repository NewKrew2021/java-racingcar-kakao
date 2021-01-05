package com.nextstep.racingcar;

import com.nextstep.racingcar.domain.Car;
import com.nextstep.racingcar.domain.InputCheck;
import com.nextstep.racingcar.domain.Racingcar;
import com.nextstep.racingcar.view.RacingcarView;

public class Application {

  public static void main(String[] args) {
    Racingcar racingcar = new Racingcar();
    RacingcarView racingcarView = new RacingcarView();

    createCars(racingcar, racingcarView);
    runRacing(racingcar, racingcarView);
    finishRacing(racingcar, racingcarView);
  }

  private static void createCars(Racingcar racingcar, RacingcarView racingcarView) {
    String[] carNames = racingcarView.inputCarNames().split(",");
    for (String carName : carNames) {
      createValidCar(racingcar, carName.trim());
    }
  }

  private static void createValidCar(Racingcar racingcar, String carName) {
    try {
      if(InputCheck.checkName(carName)) {
        racingcar.addCar(new Car(carName));
      }
    } catch (RuntimeException e) {
      System.out.println(e);
      System.exit(1);
    }
  }

  private static void runRacing(Racingcar racingcar, RacingcarView racingcarView) {
    int repetitionCount = racingcarView.inputRepetitionCount();

    racingcarView.printRaceResultMessage();
    for (int i = 0; i < repetitionCount; i++) {
      racingcar.race();
      racingcarView.printCars(racingcar);
    }
  }

  private static void finishRacing(Racingcar racingcar, RacingcarView racingcarView) {
    racingcarView.printWinners(racingcar);
  }
}
