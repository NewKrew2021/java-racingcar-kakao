package com.nextstep.racingcar.domain;

import java.util.List;

public class Racingcar {
    private Cars cars;
    private int repeatCount;
    private int currentStep;

    public Racingcar(Cars cars, int repeatCount) {
        this.cars = cars;
        this.repeatCount = repeatCount;
        this.currentStep = 0;
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public void simulate() {
        cars.move();
        increaseStep();
    }

    public boolean isInProgress() {
        return currentStep < repeatCount;
    }

    private void increaseStep() {
        currentStep++;
    }
}
