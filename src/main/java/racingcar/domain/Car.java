package racingcar.domain;

public class Car {
    private final Name name;
    private int distance;

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

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable())
            this.distance++;
    }
}
