package racingcar.domain;

import java.util.Objects;

public class CarName {

    private static final int MAX_LENGTH_OF_NAME = 5;

    private final String carName;

    public CarName(String carName) {
        checkCarNameLength(carName);
        checkCarNameEmpty(carName);
        this.carName = carName;
    }

    private void checkCarNameLength(String carName) {
        if (carName.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(String.format("이름의 길이는 %d자 이하입니다.", MAX_LENGTH_OF_NAME));
        }
    }

    private void checkCarNameEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름 공백이어서는 안 됩니다.");
        }
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName1 = (CarName) o;
        return Objects.equals(carName, carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
