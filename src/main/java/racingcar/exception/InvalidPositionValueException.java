package racingcar.exception;

public class InvalidPositionValueException extends RuntimeException {

    private static final String POSITION_EXCEPTION_MESSAGE = "0 이상의 위치만 가능합니다.";

    public InvalidPositionValueException() {
        super(POSITION_EXCEPTION_MESSAGE);
    }
}
