package racingCar;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void goForward(Integer value) {
        if (value >= 4) this.position++;
    }

    public Integer getPosition() {
        return position;
    }

    public boolean equalPosition(Car car) {
        return this.position == car.position;
    }

    @Override
    public int compareTo(Car car) {
        if (car.position > this.position) {
            return 1;
        }
        if (car.position == this.position) {
            return 0;
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString(){
        String str =this.name+" : ";
        for(int i=0;i<position;i++){
            str+='-';
        }
        return str;
    }

}
