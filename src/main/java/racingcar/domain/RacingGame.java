package racingcar.domain;

import java.util.List;

public class RacingGame {
    private static final int INITIAL_TIME = 0;
    private final Cars cars;
    private final int time;
    private int currentTime;

    public RacingGame(String carName, int time) {
        this.cars = new Cars(carName);
        this.time = time;
        this.currentTime = INITIAL_TIME;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }

    public boolean isEnd() {
        return time <= currentTime;
    }

    public void race() {
        cars.moveAll(new RandomMovingStrategy());
        currentTime++;
    }
}
