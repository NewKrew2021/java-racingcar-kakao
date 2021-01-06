package racingcar;

import java.util.Objects;

public class Position {
    private final int position;

    public Position() {
        this.position = 0;
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalStateException("시작 위치는 0 이상이여야합니다.");
        }
        this.position = position;
    }

    public Position move() {
        return new Position(position + 1);
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
