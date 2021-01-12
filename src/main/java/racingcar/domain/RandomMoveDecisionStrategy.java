package racingcar.domain;

import java.util.Random;

public class RandomMoveDecisionStrategy implements MoveDecisionStrategy {

    private static final int MIN_MOVE_REQUIRED_VALUE = 4;

    @Override
    public boolean canMove() {
        if (createRandomNumber() >= MIN_MOVE_REQUIRED_VALUE) {
            return true;
        }
        return false;
    }

    private int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(9);
    }
}
