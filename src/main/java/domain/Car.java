package domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (isMovable(number)) {
            ++position;
        }
    }

    private boolean isMovable(int number) {
        return number > RacingGame.MOVE_THRESHOLD;
    }
}