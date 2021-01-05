package com.nextstep.racingcar.racingcar;

import static com.nextstep.racingcar.ui.MessagePrinter.printRequestCarNames;
import static com.nextstep.racingcar.ui.MessagePrinter.printRequestRepeatCount;
import static com.nextstep.racingcar.ui.MessagePrinter.printResultGuide;
import static com.nextstep.racingcar.ui.MessagePrinter.printSimulationResults;
import static com.nextstep.racingcar.ui.MessagePrinter.printWinners;
import static com.nextstep.racingcar.ui.UserInput.scanCarNames;
import static com.nextstep.racingcar.ui.UserInput.scanRepeatCount;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    List<Car> cars = Stream.of(carNames)
        .map(carName -> new Car(carName, 0))
        .collect(Collectors.toList());
    
    racingcar = new Racingcar(cars, repeatCount);
  }
}
