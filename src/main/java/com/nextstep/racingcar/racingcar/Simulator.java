package com.nextstep.racingcar.racingcar;

import static com.nextstep.racingcar.ui.UserInput.*;
import static com.nextstep.racingcar.ui.MessagePrinter.*;

import java.util.ArrayList;
import java.util.List;

public class Simulator {

  private Racingcar racingcar;
  private String[] carNames;
  private int repeatCount;

  public void play() {
    getInputs();
    createNewRacingcarBasedOnInputs();

    printResultGuide();
    while (racingcar.isInProgress()) {
      racingcar.simulate();
      printSimulationResults(racingcar.getCars());
    }

    printWinners(racingcar.getWinners());
  }

  private void getInputs() {
    printRequestCarNames();
    carNames = scanCarNames();

    printRequestRepeatCount();
    repeatCount = scanRepeatCount();
  }

  private void createNewRacingcarBasedOnInputs() {
    List<Car> cars = new ArrayList<>();

    for (String carName : carNames) {
      cars.add(new Car(carName, 0));
    }

    racingcar = new Racingcar(cars, repeatCount);
  }
}
