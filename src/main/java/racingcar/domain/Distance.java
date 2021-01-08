package racingcar.domain;

import java.util.Objects;

public class Distance {
    final static int MOVE_DISTANCE = 1;

    private int distance;

    public Distance() {
        this(0);
    }

    public Distance(int distance) {
        if (distance < 0)
            throw new IllegalArgumentException();
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public int getLargerDistance(int maxDistance) {
        return Math.max(maxDistance, this.distance);
    }

    public boolean isSameDistance(int distance) {
        return this.distance == distance;
    }


    public void move() {
        this.distance += MOVE_DISTANCE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
