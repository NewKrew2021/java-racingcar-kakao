package commons;

public final class NegativeIntegerException extends Exception {
    public NegativeIntegerException() { super("음수는 입력할 수 없습니다."); }
}