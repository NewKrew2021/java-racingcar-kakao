package com.nextstep.racingcar.racingcar;

import static com.nextstep.racingcar.ui.UserInput.*;
import static com.nextstep.racingcar.ui.MessagePrinter.*;

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
    racingcar = new Racingcar(carNames, repeatCount);
  }
}
