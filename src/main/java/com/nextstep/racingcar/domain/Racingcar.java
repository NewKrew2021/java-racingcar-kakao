package com.nextstep.racingcar.domain;

import java.util.ArrayList;
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

    public Cars getCars() {
        return cars;
    }

    public Cars getWinners() {
        int highest = cars.getLocationOfHighestAdvancedCar();
        List<Car> winners = new ArrayList<>();

        cars.delegate(car -> {
            if (car.getLocation() == highest) {
                winners.add(car);
            }
        });

        return new Cars(winners);
    }

    public void simulate(MovingStrategy strategy) {
        cars.move(strategy);
        increaseStep();
    }

    public boolean isInProgress() {
        return currentStep < repeatCount;
    }

    private void increaseStep() {
        currentStep++;
    }
}
