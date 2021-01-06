package racingcar.domain;

public class InvalidGameCountException extends RuntimeException {
    private final String message;

    public InvalidGameCountException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
