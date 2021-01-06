package racingcar.domain;

import java.util.Objects;

public class Car {
    private String name;
    private int location = 0;
    static final int MIN_NAME_LENGTH = 5;
    static final int MIN_FORWARD_RANDOM = 4;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public static void validateName(String carName) {
        if (carName.length() > MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("길이 5 초과");
        }
    }

    private boolean isForword(int randomNumber) {
        return randomNumber >= MIN_FORWARD_RANDOM;
    }

    public void tryForward(int randomResult) {
        if(isForword(randomResult)) {
            this.location += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
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
