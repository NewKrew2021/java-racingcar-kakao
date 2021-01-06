package domain;

import java.util.Random;

public class RandomEngine implements Engine {
    private static final int MOVE_THRESHOLD = 4;
    private static final int UPPER_BOUND = 10;

    private final Random random;

    public RandomEngine() {
        this.random = new Random();
    }

    @Override
    public boolean canMove() {
        return random.nextInt(UPPER_BOUND) >= MOVE_THRESHOLD;
    }
}
