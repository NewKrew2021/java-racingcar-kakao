package racingcar.domain;

import racingcar.exception.InvalidPositionValueException;

import java.util.Objects;

public class Position {

    public static final int MIN_POSITION_VALUE = 0;

    private int position;

    public Position(int position) {
        validatePositionValue(position);
        this.position = position;
    }

    private void validatePositionValue(int position) {
        if (position < MIN_POSITION_VALUE) {
            throw new InvalidPositionValueException();
        }
    }

    public void goForward() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
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
