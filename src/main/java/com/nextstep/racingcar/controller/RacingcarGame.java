package com.nextstep.racingcar.controller;

import com.nextstep.racingcar.domain.Car;
import com.nextstep.racingcar.domain.Racingcar;
import com.nextstep.racingcar.view.OutputView;
import com.nextstep.racingcar.view.InputView;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingcarGame {

  private OutputView outputView;
  private InputView inputView;
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
    inputView = new InputView();
    outputView = new OutputView();
  }

  private void getInputs() {
    getCarNames();
    getRepeatCount();
  }

  private void getCarNames() {
    outputView.printRequestCarNames();
    carNames = inputView.scanCarNames();
  }

  private void getRepeatCount() {
    outputView.printRequestRepeatCount();
    repeatCount = inputView.scanRepeatCount();
  }

  private void createNewRacingcarBasedOnInputs() {
    List<Car> cars = Stream.of(carNames)
        .map(carName -> new Car(carName, 0))
        .collect(Collectors.toList());

    racingcar = new Racingcar(cars, repeatCount);
  }

  private void run() {
    outputView.printResultGuide();
    while (racingcar.isInProgress()) {
      runOneStep();
    }
  }

  private void runOneStep() {
    racingcar.simulate();
    outputView.printSimulationResults(racingcar.getCars());
  }

  private void outputWinners() {
    outputView.printWinners(racingcar.getWinners());
  }
}
