package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_EMPTY_LENGTH = 0;
    private final String name;

    Name() {
        this(null);
    }

    Name(String name) {
        checkValidName(name);
        this.name = name;
    }

    private void checkValidName(String name) {
        if (isNameEmpty(name)) {
            throw new IllegalArgumentException("이름의 길이가 0이하입니다.");
        }
        if (isLengthOver5(name)) {
            throw new IllegalArgumentException("이름의 길이가 5를 초과했습니다.");
        }
    }

    private boolean isNameEmpty(String name) {
        return name == null || name.length() <= NAME_EMPTY_LENGTH;
    }

    private boolean isLengthOver5(String name) {
        return name.length() > NAME_MAX_LENGTH;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
