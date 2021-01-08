package racingcar.domain;


import java.util.Objects;

public class Car {
    private Name name;
    private Location location;

    public Car(String name, int location) {
        this.name = new Name(name);
        this.location = new Location(location);
    }

    public String getName() {
        return name.toString();
    }

    public int getLocation() {
        return location.getLocation();
    }

    public void move(MoveStrategy moveStrategy) {
        location.move(moveStrategy);
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
