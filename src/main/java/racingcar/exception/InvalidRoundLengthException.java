package racingcar.exception;

public class InvalidRoundLengthException extends RuntimeException {
    private static final String ROUND_EXCEPTION = "횟수를 1회 이상 입력해주세요";

    public InvalidRoundLengthException() {
        super(ROUND_EXCEPTION);
    }
}
