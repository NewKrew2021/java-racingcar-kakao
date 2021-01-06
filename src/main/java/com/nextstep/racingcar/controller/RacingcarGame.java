package com.nextstep.racingcar.controller;

import com.nextstep.racingcar.domain.Car;
import com.nextstep.racingcar.domain.Racingcar;
import com.nextstep.racingcar.views.InputView;
import com.nextstep.racingcar.views.OutputView;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingcarGame {

  private InputView inputView;
  private OutputView outputView;
  private Racingcar racingcar;
  private String[] carNames;
  private int repeatCount;

  public void play() {
    initializeUI();
    getInputs();
    createNewRacingcar();

    run();

    outputWinners();
  }

  private void initializeUI() {
    inputView = new InputView();
    outputView = new OutputView();
  }

  private void getInputs() {
    carNames = inputView.scanCarNames();
    repeatCount = inputView.scanRepeatCount();
  }

  private void createNewRacingcar() {
    List<Car> cars = Stream.of(carNames)
        .map(carName -> new Car(carName, 0))
        .collect(Collectors.toList());

    racingcar = new Racingcar(cars, repeatCount);
  }

  private void run() {
    outputView.printResultGuide();
    while (racingcar.isInProgress()) {
      racingcar.simulate();
      outputView.printSimulationResults(racingcar.getCars());
    }
  }

  private void outputWinners() {
    outputView.printWinners(racingcar.getWinners());
  }
}