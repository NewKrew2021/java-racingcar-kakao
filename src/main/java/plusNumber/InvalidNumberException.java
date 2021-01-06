package plusNumber;

public class InvalidNumberException extends RuntimeException {

    public InvalidNumberException() {
        super();
    }

    public InvalidNumberException(String message) {
        super(message);
    }
}
