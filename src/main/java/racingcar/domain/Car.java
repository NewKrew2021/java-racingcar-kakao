package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int MIN_FORWARD_RANDOM = 4;
    private Name name;
    private final Location location;

    public Car() {
        location = new Location(0);
    }

    public Car(String name) {
        this();
        this.name = new Name(name);
    }

    private boolean isForword(int randomNumber) {
        return randomNumber >= MIN_FORWARD_RANDOM;
    }

    public void tryForward(int randomResult) {
        if (isForword(randomResult)) {
            location.move();
        }
    }

    public boolean isEqualLocation(int location) {
        return this.location.same(location);
    }

    public int getLocation() {
        return location.getLocation();
    }

    public String getName() {
        return name.getName();
    }

    public int maxLocation(int location) {
        return this.location.max(location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(location, car.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}
