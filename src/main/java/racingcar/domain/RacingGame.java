package racingcar.domain;

import java.util.List;

public class RacingGame {
    private Cars cars;
    private TryNo tryNo;

    public RacingGame(Cars cars, TryNo tryNo) {
        this.cars = cars;
        this.tryNo = tryNo;
    }

    public void race() {
        this.cars.moveCars();
        tryNo.decrease();
    }

    public boolean isEnd() {
        return tryNo.isZero();
    }

    public List<Car> getWinners() {
        return this.cars.findWinners();
    }

    public Cars getCars() {
        return this.cars;
    }

}