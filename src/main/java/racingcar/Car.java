package racingcar;

public class Car {
    public static void validateName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("길이 5 초과");
        }
    }
}
