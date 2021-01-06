package racingcar.exception;

public class InvalidCarNameLengthException extends RuntimeException{
    public InvalidCarNameLengthException(String errorMessage){
        super(errorMessage);
    }
}
