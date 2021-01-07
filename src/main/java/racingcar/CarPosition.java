package racingcar;

import java.util.Objects;

public class CarPosition {

    private int carPosition;

    public CarPosition(int position) {
        this.carPosition = position;
    }

    public int move(MovingStrategy strategy) {
        if (strategy.isMoving()) {
            carPosition += 1;
        }
        return carPosition;
    }

    public boolean isMatched(int position) {
        return this.carPosition == position;
    }

    public int getCarPosition() {
        return carPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return carPosition == that.carPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carPosition);
    }
}
