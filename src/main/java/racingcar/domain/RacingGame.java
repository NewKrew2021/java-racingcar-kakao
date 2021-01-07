package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final int time;
    private int currentTime;

    public RacingGame(String carName, int time) {
        this.cars = new Cars(carName);
        this.time = time;
    }

    public Cars getCars() {
        return cars;
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
