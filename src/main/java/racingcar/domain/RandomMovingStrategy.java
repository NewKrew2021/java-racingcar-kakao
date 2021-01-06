package racingcar.domain;

public class RandomMovingStrategy implements MovingStrategy {

    static final int DISTANCE_LIMIT = 10;
    static final int MIN_MOVABLE_NUMBER = 4;

    @Override
    public boolean isMove() {
        int randomNumber = makeRandomNumber();
        return randomNumber >= MIN_MOVABLE_NUMBER;
    }

    private int makeRandomNumber() {
        return (int) (Math.random() * DISTANCE_LIMIT);
    }
}
