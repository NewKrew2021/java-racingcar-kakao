package domain;

import racinggame.MoveStrategy;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name == null ||
                name.length() > 5 ||
                name.equals("")) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public Car(String name, int position) {
        this(name);
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public int move(MoveStrategy strategy) {
        if (strategy.isMove())
            ++this.position;
        return this.position;
    }

    @Override
    public int compareTo(Car o) {
        if (this.position > o.position)
            return -1;
        if (this.position < o.position)
            return 1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public String toString() {
        String repeat = "";
        for (int i = 0; i < this.position; i++) {
            repeat += "-";
        }
        return this.name + " : " + repeat;
    }
}
