package racingcar.domain;

import racingcar.util.CheckMovable;

import java.util.Objects;

public class RacingCar {
    private int dist;

    private final String name;

    public RacingCar(String name) {
        this.name = name;
        this.dist = 0;
    }

    public int move(CheckMovable checkMovable) {
        if (checkMovable.isMovable()) {
            return ++this.dist;
        }
        return this.dist;
    }

    public String getName() {
        return this.name;
    }

    public int getDist() {
        return this.dist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return dist == racingCar.dist && Objects.equals(name, racingCar.name);
    }
}
