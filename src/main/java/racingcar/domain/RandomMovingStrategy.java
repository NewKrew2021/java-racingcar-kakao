package racingcar.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    public static final int FORWARD = 4;

    @Override
    public boolean movable() {
        return getRandomNumber() >= FORWARD;
    }

    public int getRandomNumber() {
        return new Random().nextInt(10);
    }
}
