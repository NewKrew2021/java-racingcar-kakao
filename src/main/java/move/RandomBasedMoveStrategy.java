package move;

import java.util.Random;

public class RandomBasedMoveStrategy implements MoveStrategy {
    private static final int RANDOM_MAX = 10;
    private static final int RANDOM_MOVE_NUMBER = 4;

    // singleton
    private static RandomBasedMoveStrategy instance;

    private RandomBasedMoveStrategy() {
    }

    public static RandomBasedMoveStrategy getInstance() {
        if (instance == null)
            instance = new RandomBasedMoveStrategy();
        return instance;
    }

    @Override
    public boolean isMove() {
        return new Random().nextInt(RANDOM_MAX) >= RANDOM_MOVE_NUMBER;
    }
}
