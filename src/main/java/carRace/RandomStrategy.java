package carRace;

public class RandomStrategy implements MovingStrategy{
    private static final int MAX_BOUND = 10;
    private static final int MOVE_BOUND = 4;

    @Override
    public boolean movable() {
        return MOVE_BOUND <= getRandomNumber();
    }

    public int getRandomNumber() {
        return (int)(Math.random() * MAX_BOUND);
    }
}
