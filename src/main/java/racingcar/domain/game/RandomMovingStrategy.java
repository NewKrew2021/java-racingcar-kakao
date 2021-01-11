package racingcar.domain.game;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int RANDOM_SCOPE = 10;
    private static final int STOP_RANDOM_NUMBER = 4;

    @Override
    public boolean moveable() {
        return makeRandomNumber() >= STOP_RANDOM_NUMBER;
    }

    protected int makeRandomNumber() {
        return (int) (Math.random() * RANDOM_SCOPE);
    }
}
