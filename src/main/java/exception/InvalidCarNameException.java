package exception;

public class InvalidCarNameException extends RuntimeException{

    @Override
    public String getMessage() {
        return "잘못된 자동차 이름입니다";
    }
}
