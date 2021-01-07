package racingcar.exception;

public class InvalidCarNameLengthException extends RuntimeException {
    public InvalidCarNameLengthException() {
        super("길이를 5이하로 설정해주세요");
    }
}
