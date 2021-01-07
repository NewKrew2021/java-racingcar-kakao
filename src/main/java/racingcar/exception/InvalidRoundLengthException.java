package racingcar.exception;

public class InvalidRoundLengthException extends RuntimeException {
    public InvalidRoundLengthException() {
        super("횟수를 1회 이상 입력해주세요.");
    }
}
