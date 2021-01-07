package com.nextstep.racingcar.controller;

import com.nextstep.racingcar.domain.Car;
import com.nextstep.racingcar.domain.Cars;
import com.nextstep.racingcar.domain.Racingcar;
import com.nextstep.racingcar.views.InputView;
import com.nextstep.racingcar.views.OutputView;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingcarGame {
    private InputView userInput;
    private OutputView gameOutput;
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
        userInput = new InputView();
        gameOutput = new OutputView();
    }

    private void getInputs() {
        carNames = userInput.scanCarNames();
        repeatCount = userInput.scanRepeatCount();
    }

    private void createNewRacingcar() {
        Cars cars = new Cars(Stream.of(carNames)
                .map(carName -> new Car(carName, 0))
                .collect(Collectors.toList()));

        racingcar = new Racingcar(cars, repeatCount);
    }

    private void run() {
        gameOutput.printResultGuide();
        while (racingcar.isInProgress()) {
            racingcar.simulate();
            gameOutput.printSimulationResults(racingcar.getCars());
        }
    }

    private void outputWinners() {
        Cars winners = racingcar.getCars().getWinners();
        gameOutput.printWinners(winners);
    }
}
