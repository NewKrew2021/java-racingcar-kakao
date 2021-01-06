package racingcar.domain;

import java.util.Objects;

public class RacingCar {

    private final Name name;
    private Distance distance;

    public RacingCar(String name) {
        this.name = new Name(name);
        this.distance = new Distance();
    }

    public RacingCar(String name,int distance) {
        this.name = new Name(name);
        this.distance = new Distance(distance);
    }

    public Name getName() {
        return this.name;
    }

    public Distance getDistance() {
        return this.distance;
    }

    public void tryMove(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            this.distance.move();
        }
    }

    public int getLargerDistance(int maxDistance) {
        return this.distance.getLargerDistance(maxDistance);
    }

    public boolean isSameDistance(int maxDistance) {
        return this.distance.isSameDistance(maxDistance);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name) && Objects.equals(distance, racingCar.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }


}
