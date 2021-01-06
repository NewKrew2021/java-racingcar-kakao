package racingcar.domain;


public class RacingGame {
    private static final int END_NO = 0;
    private Cars cars;
    private int tryNo;

    public RacingGame(String[] names, int tryNo) {
        cars = new Cars(names);
        this.tryNo = tryNo;
    }

    public void race() {
        cars.moveCars(getRandomNo());
        tryNo--;
    }

    public boolean isEnd() {
        return tryNo == END_NO;
    }

    private int getRandomNo() {
        return (int) (Math.random() * 10);
    }
}