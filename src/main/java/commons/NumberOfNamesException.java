package commons;

public final class NumberOfNamesException extends Exception {
    public NumberOfNamesException() {
        super("이름은 최소 2개 이상 작성하세요.");
    }
}
