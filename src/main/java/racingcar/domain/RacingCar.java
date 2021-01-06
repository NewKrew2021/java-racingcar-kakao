package racingcar.domain;

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
}
