package racingcar.exceptions;

public class InvalidCarNameException extends RuntimeException {
    private final String message;

    public InvalidCarNameException(String message) {
        this.message = message;
    }

    public void printErrorMessage(String name) {
        System.out.println(message + name);
    }
}
