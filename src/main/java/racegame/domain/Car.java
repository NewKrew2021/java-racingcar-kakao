package racegame.domain;

import java.util.Objects;

public class Car {

    private final Name name;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Integer getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    public void move(Integer value) {
        this.position = this.position.move(value);
    }

    public boolean isEqualPosition(int maxPosition) {
        return this.position.equals(new Position(maxPosition));
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
