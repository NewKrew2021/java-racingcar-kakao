package com.nextstep.racingcar;

import com.nextstep.racingcar.racingcar.Racingcar;
import com.nextstep.racingcar.ui.UserInput;

import static com.nextstep.racingcar.ui.MessagePrinter.*;

public class Simulator {

  private UserInput inp;
  private Racingcar racingcar;
  private String[] carNames;
  private int repeatCount;

  public void play() {
    initializeUI();
    getInputs();
    createNewRacingcarBasedOnInputs();

    printResultGuide();
    while (racingcar.isInProgress()) {
      racingcar.simulate();
      printSimulationResults(racingcar);
    }

    printWinners(racingcar.getWinners());
  }

  private void initializeUI() {
    inp = new UserInput();
  }

  private void getInputs() {
    printRequestCarNames();
    carNames = inp.getCarNames();

    printRequestRepeatCount();
    repeatCount = inp.getRepeatCount();
  }

  private void createNewRacingcarBasedOnInputs() {
    racingcar = new Racingcar(carNames, repeatCount);
  }
}
