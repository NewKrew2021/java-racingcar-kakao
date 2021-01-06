package racingcar.domain;

import racingcar.io.Text;

import java.util.Objects;

public class Car {
    private final String name;
    private int location = 0;

    private static final int MIN_NAME_LENGTH = 5;
    private static final int MIN_FORWARD_RANDOM = 4;

    public Car(String name, int location){
        this(name);
        this.location = location;
    }

    public Car(String name){
        validateName(name);
        this.name = name;
    }

    public static void validateName(String carName) {
        if (carName.length() > MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(Text.ILLEGAL_CAR_NAME_LENGTH);
        }
    }

    public boolean isForward(int randomNumber) {
        return randomNumber >= MIN_FORWARD_RANDOM;
    }

    public void tryForward(int randomResult) {
        if(isForward(randomResult)) {
            this.location++;
        }
    }

    public String getName(){
        return name;
    }

    public int getLocation() {
        return location;
    }

    public boolean isInLocation(int location){
        return this.location == location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return location == car.location && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}
