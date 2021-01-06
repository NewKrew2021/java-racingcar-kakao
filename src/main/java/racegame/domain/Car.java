package racegame.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final Name name;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    public void move(Integer randomValue) {
        this.position = this.position.move(randomValue);
    }

    @Override
    public int compareTo(Car car) {
        return car.position.compareTo(this.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return this.name + " : " + this.position;
    }

}
