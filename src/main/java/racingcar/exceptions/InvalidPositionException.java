package racingcar.exceptions;

public class InvalidPositionException extends RuntimeException{
    private final String message;

    public InvalidPositionException(String message) {
        this.message = message;
    }

    public void printErrorMessage() {
        System.out.println(message);
    }
}
