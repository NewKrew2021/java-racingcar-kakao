package com.nextstep.racingcar.domain;

public class Racingcar {
    private Cars cars;
    private int repeatCount;
    private int currentStep;

    public Racingcar(Cars cars, int repeatCount) {
        this.cars = cars;
        this.repeatCount = repeatCount;
        this.currentStep = 0;
    }

    public Cars getCars() {
        return cars;
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
