package racingcar.domain;

import java.util.Objects;

public class Position {

    private static final int MOVEMENT = 1;
    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) throws InvalidPositionException {
        if (position < 0) {
            throw new InvalidPositionException("Position은 음수가 될 수 없습니다.");
        }
        this.position = position;
    }

    public void nextStep() {
        position += MOVEMENT;
    }

    public int getPosition() {
        return position;
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
