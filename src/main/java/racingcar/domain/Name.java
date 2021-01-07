package racingcar.domain;

import racingcar.utils.StringUtils;

import java.util.Objects;

public class Name {
    private static final int LIMIT_NAME = 5;
    private final String name;

    public Name(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
        if (name.length() > LIMIT_NAME) {
            throw new IllegalArgumentException("이름이 5자를 초과하였습니다.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
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
