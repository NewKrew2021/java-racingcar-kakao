package domain;

import java.util.Objects;

public class Car {
    private static final int THRESHOLD = 3;
    private static final int MAX_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        if (isBlank(name) || name.length() > MAX_LENGTH)
            throw new IllegalArgumentException("자동차 이름은 1글자 이상 5글자 이하로 해주세요!");

        this.name = name;
        this.position = position;
    }

    private boolean isBlank(String name) {
        return name == null || name.equals("") || name.equals(" ");
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void runWithCondition(int value) {
        if (value <= THRESHOLD) {
            return;
        }
        this.position++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
