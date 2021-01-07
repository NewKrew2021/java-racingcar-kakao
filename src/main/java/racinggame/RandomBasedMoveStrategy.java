package racinggame;

import java.util.Random;

public class RandomBasedMoveStrategy implements MoveStrategy {
    private static final int RANDOM_MAX = 10;
    private static final int RANDOM_MOVE_NUMBER = 4;

    @Override
    public boolean isMove() {
        return new Random().nextInt(RANDOM_MAX) >= RANDOM_MOVE_NUMBER;
    }
}
