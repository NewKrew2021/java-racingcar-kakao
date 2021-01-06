package com.nextstep.racingcar.racingcar;

import com.nextstep.racingcar.ui.gameOutput;
import com.nextstep.racingcar.ui.UserInput;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Simulator {

  private gameOutput gameOutput;
  private UserInput userInput;
  private Racingcar racingcar;
  private String[] carNames;
  private int repeatCount;

  public void play() {
    initializeUI();
    getInputs();
    createNewRacingcarBasedOnInputs();

    run();

    outputWinners();
  }

  private void initializeUI() {
    userInput = new UserInput();
    gameOutput = new gameOutput();
  }

  private void getInputs() {
    getCarNames();
    getRepeatCount();
  }

  private void getCarNames() {
    gameOutput.printRequestCarNames();
    carNames = userInput.scanCarNames();
  }

  private void getRepeatCount() {
    gameOutput.printRequestRepeatCount();
    repeatCount = userInput.scanRepeatCount();
  }

  private void createNewRacingcarBasedOnInputs() {
    List<Car> cars = Stream.of(carNames)
        .map(carName -> new Car(carName, 0))
        .collect(Collectors.toList());

    racingcar = new Racingcar(cars, repeatCount);
  }

  private void run() {
    gameOutput.printResultGuide();
    while (racingcar.isInProgress()) {
      runOneStep();
    }
  }

  private void runOneStep() {
    racingcar.simulate();
    gameOutput.printSimulationResults(racingcar.getCars());
  }

  private void outputWinners() {
    gameOutput.printWinners(racingcar.getWinners());
  }
}
