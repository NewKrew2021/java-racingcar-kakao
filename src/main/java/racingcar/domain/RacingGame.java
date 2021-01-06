package racingcar.domain;

import java.util.List;

public class RacingGame {
    private static final int END_NO = 0;
    private Cars cars;
    private int tryNo;

    public RacingGame(Cars cars, int tryNo) {
        this.cars = cars;
        this.tryNo = tryNo;
    }

    public void race() {
        this.cars.moveCars();
        this.tryNo--;
    }

    public boolean isEnd() {
        return this.tryNo == END_NO;
    }

    public List<Car> getWinners() {
        return this.cars.findWinners();
    }

    public Cars getCars(){
        return this.cars;
    }

}