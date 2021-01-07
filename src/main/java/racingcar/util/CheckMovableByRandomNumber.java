package racingcar.util;

public class CheckMovableByRandomNumber implements CheckMovable {
    protected static final int MIN_MOVABLE_NUMBER = 4;
    private static final int DISTANCE_LIMIT = 10;

    @Override
    public boolean isMovable() {
        return makeRandomValue() >= MIN_MOVABLE_NUMBER;
    }

    protected int makeRandomValue() {
        return (int) (Math.random() * DISTANCE_LIMIT);
    }
}
