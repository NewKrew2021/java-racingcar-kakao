package racingcar.exception;

public class InvalidPositionValueException extends RuntimeException {

    public InvalidPositionValueException() {
        super();
    }

    public InvalidPositionValueException(String message) {
        super(message);
    }
}
