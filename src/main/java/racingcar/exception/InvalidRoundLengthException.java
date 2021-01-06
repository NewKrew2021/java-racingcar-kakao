package racingcar.exception;

public class InvalidRoundLengthException extends RuntimeException {
    public InvalidRoundLengthException(String errorMessage){
        super(errorMessage);
    }
}
