package racingcar.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MAX_BOUND = 10;

    @Override
    public int moveNumber() {
        return getRandomNumber();
    }

    public int getRandomNumber() {
        return new Random().nextInt(MAX_BOUND);
    }
}
