package carRace.strategy;

public class RandomStrategy implements MovingStrategy {
    private static final int MAX_BOUND = 10;
    private static final int MOVE_BOUND = 4;

    @Override
    public boolean movable() {
        return getRandomNumber() >= MOVE_BOUND;
    }

    protected int getRandomNumber() {
        return (int)(Math.random() * MAX_BOUND);
    }
}
