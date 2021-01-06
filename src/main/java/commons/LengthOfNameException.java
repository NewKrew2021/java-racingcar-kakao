package commons;

public final class LengthOfNameException extends Exception {
    public LengthOfNameException(String name) { super(name + ": 이름은 최대 5자 이내로 작성하세요."); }
}