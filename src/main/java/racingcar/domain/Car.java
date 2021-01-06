package racingcar.domain;

import java.util.Objects;

public class Car {
    static final int MIN_FORWARD_RANDOM = 4;
    static final int MOVE_FORWARD = 1;
    private Name name;
    private int location;

    public Car(String name) {
        this.name = new Name(name);
    }

    private boolean isForword(int randomNumber) {
        return randomNumber >= MIN_FORWARD_RANDOM;
    }

    public void tryForward(int randomResult) {
        if (isForword(randomResult)) {
            this.location += +MOVE_FORWARD;
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return location == car.location && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}
