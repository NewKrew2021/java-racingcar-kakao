package com.nextstep.racingcar;

import com.nextstep.racingcar.domain.Car;
import com.nextstep.racingcar.domain.Racingcar;
import com.nextstep.racingcar.view.RacingcarView;
import java.util.Arrays;

public class Application {

  public static void main(String[] args) {
    Racingcar racingcar = new Racingcar();
    RacingcarView racingcarView = new RacingcarView(racingcar);

    createCars(racingcar, racingcarView);
    runRacing(racingcar, racingcarView);
    finishRacing(racingcarView);
  }

  private static void createCars(Racingcar racingcar, RacingcarView racingcarView) {
    String carNames = racingcarView.inputCarNames();
    Arrays.stream(carNames.split(","))
        .forEach(carName -> racingcar.addCar(new Car(carName)));
  }

  private static void runRacing(Racingcar racingcar, RacingcarView racingcarView) {
    int repetitionCount = racingcarView.inputRepetitionCount();

    racingcarView.printRaceResultMessage();
    for (int i = 0; i < repetitionCount; i++) {
      racingcar.race();
      racingcarView.printCars();
    }
  }

  private static void finishRacing(RacingcarView racingcarView) {
    racingcarView.printWinners();
  }
}
