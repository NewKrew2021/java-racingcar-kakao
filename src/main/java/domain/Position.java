package domain;

import java.util.stream.IntStream;

public class Position {
    private int data;

    public Position() {
        this.data = 0;
    }

    public void increase() {
        this.data++;
    }

    @Override
    public String toString() {
        return IntStream.range(0, this.data)
                .mapToObj(value -> "-")
                .reduce("", (total, s) -> total + s);
    }

    public int getPosition() {
        return this.data;
    }
}
