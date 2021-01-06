package racingcar;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int RANDOM_SCOPE = 10;
    private static final int STOP_RANDOM_NUMBER = 4;

    @Override
    public boolean moveable() {
        if (makeRandomNumber() < STOP_RANDOM_NUMBER) {
            return false;
        }
        return true;
    }

    private int makeRandomNumber() {
        return (int) (Math.random() * RANDOM_SCOPE);
    }
}
