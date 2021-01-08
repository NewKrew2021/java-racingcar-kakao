package racingcar.domain;

import java.util.*;

public class RacingGame {

    private Cars cars;


    public RacingGame(String namesText) {
        cars = new Cars(namesText);
    }

    public void race(RapTime rapTime) {
        rapTime.downTime();
        cars.moveAll();
    }

    public List<Car> getRaceStatus() {
        return cars.getCars();
    }

    public List<String> getRaceWinners() {
        return cars.getRaceWinners();
    }
}
