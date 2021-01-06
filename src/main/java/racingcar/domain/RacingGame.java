package racingcar.domain;

import java.util.List;

public class RacingGame {
    private static final int END_NO = 0;
    private Cars cars;
    private int tryNo;

    public RacingGame(String[] names, int tryNo) {
        this.cars = new Cars(names);
        this.tryNo = tryNo;
    }

    public void race() {
        this.cars.moveCars(getRandomNo());
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

    private int getRandomNo() {
        return (int) (Math.random() * 10);
    }

}