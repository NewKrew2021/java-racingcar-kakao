package racingcar.domain;

import racingcar.exceptions.InvalidPositionException;

import java.util.Objects;

public class Position {

    private static final int MOVEMENT = 1;
    private static final int SPEED = 4;
    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        if(position < 0) {
            throw new InvalidPositionException("Position은 음수가 될 수 없습니다.");
        }
        this.position = position;
    }

    public void nextStep(int currentSpeed) {
        if(isCarGo(currentSpeed)) {
            position += MOVEMENT;
        }
    }

    public int getPosition() {
        return position;
    }

    public boolean isCarGo(int currentSpeed) {
        return currentSpeed >= SPEED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
