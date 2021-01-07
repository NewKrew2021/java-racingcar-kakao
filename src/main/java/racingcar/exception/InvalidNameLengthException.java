package racingcar.exception;

public class InvalidNameLengthException extends RuntimeException {

    public InvalidNameLengthException() {
        super();
    }

    public InvalidNameLengthException(String message) {
        super(message);
    }
}
