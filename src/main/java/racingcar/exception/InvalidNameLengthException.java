package racingcar.exception;

public class InvalidNameLengthException extends RuntimeException {

    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "이름은 5자 이하만 가능합니다.";

    public InvalidNameLengthException() {
        super(NAME_LENGTH_EXCEPTION_MESSAGE);
    }
}
