package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    protected int maxPosition() {
        int mxPosition = 0;
        for (Car car : cars) {
            mxPosition = car.max(mxPosition);
        }
        return mxPosition;
    }

    protected void moveAll() {
        for (Car car : cars) {
            car.move(new RandomNumber());
        }
    }

    protected Winners filterWinners() {
        int maxPosition = maxPosition();

        Winners winners = new Winners();
        for (Car car : cars) {
            winners.addWinner(maxPosition, car);
        }

        return winners;
    }

    @Override
    public String toString() {
        StringBuilder carsString = new StringBuilder();

        for (Car car : cars) {
            carsString.append(car);
            carsString.append('\n');
        }

        return carsString.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
