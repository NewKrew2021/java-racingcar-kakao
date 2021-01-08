package com.nextstep.racingcar.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private final int MOVE_STARTING_FROM = 4;
    private final int RANGE = 10;
    private final Random random = new Random();

    @Override
    public boolean isMove() {
        return random.nextInt(RANGE) >= MOVE_STARTING_FROM;
    }
}
