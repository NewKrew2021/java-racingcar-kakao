package racegame.domain;

import java.util.Objects;
import java.util.stream.IntStream;

public class Position implements Comparable<Position> {

    public static final int CANNOT_MOVE = 4;
    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public Position() {
        this(0);
    }

    public int getPosition() {
        return position;
    }

    public Position move(int randomNo) {
        if (randomNo > CANNOT_MOVE) {
            return new Position(this.position + 1);
        }
        return this;
    }

    @Override
    public int compareTo(Position position) {
        return Integer.compare(position.getPosition(), this.getPosition());
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
        return IntStream.range(0, position)
                .mapToObj(e -> "-")
                .reduce("", (acc, cur) -> acc + cur);
    }

}
