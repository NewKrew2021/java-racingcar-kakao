package racingcar.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int FORWARD = 4;
    private static final int MAX_BOUND = 10;

    @Override
    public boolean movable() {
        return getRandomNumber() >= FORWARD;
    }

    public int getRandomNumber() {
        return new Random().nextInt(MAX_BOUND);
    }
}
