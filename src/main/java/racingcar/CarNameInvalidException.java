package racingcar;

public class CarNameInvalidException extends RuntimeException {
    private final String message;

    public CarNameInvalidException(String message) {
        this.message = message;
    }

    public void printErrorMessage(String name) {
        System.out.println(message + name);
    }
}
