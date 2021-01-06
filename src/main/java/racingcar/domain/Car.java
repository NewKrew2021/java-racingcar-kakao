package racingcar.domain;

import java.util.Objects;

public class Car {
    private final Name name;
    private Position position;

    public Car(String name) {
        this(name, 1);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Position getPosition() {
        return position;
    }

    protected void move(RandomNumber randomNo) {
        if (randomNo.isMovable()) {
            position = position.move();
        }
    }

    public Name getName() {
        return name;
    }

    protected boolean isWinner(int maxPosition) {
        return position.isEqual(maxPosition);
    }

    protected int max(int position) {
        if (this.position.isGreaterThan(position)) {
            return this.position.getPosition();
        }
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
