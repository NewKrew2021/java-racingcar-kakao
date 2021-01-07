package racingcar.domain;

import racingcar.exception.InvalidPositionValueException;

import java.util.Objects;

public class Position {

    private int position;

    public Position(int position) {
        validatePositionValue(position);
        this.position = position;
    }

    public void goForward() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    private void validatePositionValue(int position) {
        if (position < 0) {
            throw new InvalidPositionValueException("0 이상의 포지션만 가능합니다.");
        }
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
