package racingcar.exception;

public class InvalidRoundValueException extends RuntimeException {

    public InvalidRoundValueException() {
        super();
    }

    public InvalidRoundValueException(String message) {
        super(message);
    }
}
