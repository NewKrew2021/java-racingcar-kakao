package racingcar.exception;

public class InvalidRoundValueException extends RuntimeException {

    private static final String ROUND_EXCEPTION_MESSAGE = "0 이상의 이동 횟수를 입력하세요.";

    public InvalidRoundValueException() {
        super(ROUND_EXCEPTION_MESSAGE);
    }
}
