package racingcar;

public class Car {
    public static void validateName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("길이 5 초과");
        }
    }

    public boolean isForword(int randomNumber) {
        return randomNumber >= MIN_FORWARD_RANDOM;
    }

    public void tryForward(int randomResult) {
        if(isForword(randomResult)) {
            this.location += 1;
        }
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
