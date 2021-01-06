package racingcar.domain;

public class InvalidCarNameException extends RuntimeException {
    private final String message;

    public InvalidCarNameException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
