package racingCar;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public Integer getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void goForward(Integer value) {
        if (value >= 4) this.position++;
    }

    public boolean equalPosition(Car car) {
        return this.position == car.position;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(car.getPosition(), getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        String result = this.name + " : ";
        for (int i = 0; i < position; i++) {
            result += "-";
        }
        return result;
    }

}
