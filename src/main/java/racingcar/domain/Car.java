package racingcar.domain;

public class Car {
    private static final int FORWARD = 4;
    private final Name name;
    private int distance;

    public Car(String name) {
        this.name = new Name(name);
    }

    public Car(String name, int distance) {
        this.name = new Name(name);
        this.distance = distance;
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance;
    }

    public boolean hasSameDistance(int distance) {
        return this.distance == distance;
    }

    public void move(int moveNumber) {
        if (moveNumber >= FORWARD)
            this.distance++;
    }
}
