package racingcar.domain;

import java.util.Objects;

public class Location {
    private static final int MIN_LOCATION = 0;
    private int location;

    public Location(int location) {
        checkInvalid(location);
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public void move() {
        this.location++;
    }

    public int max(int location) {
        return Math.max(this.location, location);
    }

    private void checkInvalid(int location) {
        if (location < MIN_LOCATION) {
            throw new IllegalArgumentException("값이 음수입니다.");
        }
    }

    public boolean same(int location) {
        return this.location == location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location1 = (Location) o;
        return location == location1.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
