package racingcar.domain.car;

import racingcar.domain.game.MovingStrategy;

import java.util.Objects;

public class Car {

    private Position position;
    private final Name name;

    private Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public static Car of(String name, int position) {
        return new Car(name, position);
    }

    public void moveCarPosition(MovingStrategy movingStrategy) {
        if (movingStrategy.moveable()) {
            this.position = position.move();
        }
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public String getName() {
        return this.name.getName();
    }
}
