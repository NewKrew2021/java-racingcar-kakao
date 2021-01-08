package com.nextstep.racingcar.domain;

import java.util.Objects;

public class Car {
    private String name;
    private int location;

    public Car(String carName, int location) {
        if (isAboveFiveLetters(carName)) {
            throw new RuntimeException("Car cannot handle a name larger than 5");
        }

        this.name = carName;
        this.location = location;
    }

    public void move() {
        this.location += 1;
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car that = (Car) o;
        return name.equals(that.name) && location == that.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    private boolean isAboveFiveLetters(String name) {
        return name.length() > 5;
    }
}
