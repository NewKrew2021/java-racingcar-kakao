package racingcar.domain;

import java.util.List;

public class RacingGame {
    private Cars cars;
    private TryNo tryNo;

    public RacingGame(List<String> names, TryNo tryNo) {
        this.cars = Cars.of(names);
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