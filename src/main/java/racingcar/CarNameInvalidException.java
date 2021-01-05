package racingcar;

public class CarNameInvalidException extends RuntimeException {
    public CarNameInvalidException(String message) {
        System.out.println(message);
    }
}
