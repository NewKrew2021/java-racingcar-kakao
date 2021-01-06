package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final int STEP = 1;
    private final int position;

    public Position() {
        this(1);
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치 값은 양수입니다.");
        }

        this.position = position;
    }

    public Position move() {
        //immutable 성능개선 방법 고안해보기
        return new Position(position + STEP);
    }

    public boolean isEqual(int mx) {
        return mx == position;
    }

    public boolean isGreaterThan(int position) {
        return this.position > position;
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

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();

        for (int i = 0; i < position; i++) {
            stb.append("-");
        }

        return stb.toString();
    }
}
