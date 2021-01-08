package racingcar.exception;

public class InvalidCarNameLengthException extends RuntimeException {
    private static final String NAME_EXCEPTION = "길이를 5이하로 설정해주세요";

    public InvalidCarNameLengthException() {
        super(NAME_EXCEPTION);
    }
}
