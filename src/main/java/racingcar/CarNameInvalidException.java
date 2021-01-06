package racingcar;

public class CarNameInvalidException extends RuntimeException {

    public CarNameInvalidException(String message, String name) {
        System.out.println(message + name);
    }

}
