package carRace.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int LOWER_LIMIT_OF_MOVE = 4;
    Random random = new Random();

    @Override
    public boolean movable() {
        return LOWER_LIMIT_OF_MOVE <= random.nextInt();
    }
}
