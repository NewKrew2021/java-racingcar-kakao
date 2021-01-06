package racingcar.domain;

import racingcar.exceptions.InvalidCarNameException;
import racingcar.exceptions.InvalidPositionException;

import java.util.*;

public class RacingGame {

    private Cars cars;

    public RacingGame(String inputCarNames) {
        cars = new Cars(inputCarNames);
    }

    public void racing() {
        cars.raceAll();
    }

    public List<CarInfo> getStatus() {
        return cars.getStatus();
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }

}
