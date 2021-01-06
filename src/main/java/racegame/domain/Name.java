package racegame.domain;

public class Name {

    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름이 너무 깁니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
