package racingcar.domain;

import racingcar.utils.RandomUtils;

public class RandomMovingStrategy implements MovingStrategy{
    private static final int MIN_SPEED = 4;
    private static final int RANGE = 10;

    @Override
    public boolean isMovable() {
        return RandomUtils.generateRandomNumber(RANGE) >= MIN_SPEED;
    }
}
