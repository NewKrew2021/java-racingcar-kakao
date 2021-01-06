package racingcar.domain;

public class InvalidPositionException extends RuntimeException{
    private final String message;

    public InvalidPositionException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
