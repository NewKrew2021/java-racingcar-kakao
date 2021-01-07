package racingcar.domain;

import racingcar.exception.InvalidNameLengthException;

import java.util.Objects;

public class Car {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String name;
    private final Position position;

    public Car(String name) {
        this(name, 1);
    }

    public Car(String name, int position) {
        validateNameLength(name);
        this.name = name;
        this.position = new Position(position);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move(int value) {
        if (value >= 4) {
            position.goForward();
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new InvalidNameLengthException("이름은 5자 이하만 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
