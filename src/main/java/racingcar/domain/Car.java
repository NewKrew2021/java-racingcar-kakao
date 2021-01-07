package racingcar.domain;

public class Car {

    private static final MovingStrategy movingStrategy = new RandomMovingStrategy();

    private final CarName name;
    private CarPosition position;

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new CarPosition(position);
    }

    public int move() {
        return position.move(movingStrategy);
    }

    public int getPosition() {
        return position.getCarPosition();
    }

    public String getName() {
        return name.getCarName();
    }

    public boolean isMatched(int position) {
        return this.position.isMatched(position);
    }
}
