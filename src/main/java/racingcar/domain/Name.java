package racingcar.domain;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {

        this.name = validateFormat(name);
    }

    public String getName() {

        return this.name;
    }

    private String validateFormat(String name) {

        if (name.length() > 5 || name.length() == 0) {
            throw new IllegalArgumentException("이름 포멧이 잘못되었습니다.");
        }
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

    @Override
    public String toString() {
        return name;
    }
}
