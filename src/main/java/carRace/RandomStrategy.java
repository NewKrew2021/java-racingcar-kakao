package carRace;

public class RandomStrategy implements MovingStrategy{
    public static final int MAX_BOUND = 10;

    @Override
    public boolean movable() {
        return 4 <= getRandomNumber();
    }

    public int getRandomNumber() {
        return (int)(Math.random() * MAX_BOUND);
    }
}
