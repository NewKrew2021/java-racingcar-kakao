package racingcar;

public class Car {

    private Position position = new Position();
    private Name name;

    private Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public static Car of(String name, int position) {
        return new Car(name, position);
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public String getName() {
        return this.name.getName();
    }

    public void moveCarPosition(MovingStrategy movingStrategy) {
        if (movingStrategy.moveable()) {
            this.position = position.move();
        }
    }
}
