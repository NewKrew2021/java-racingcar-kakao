package racingcar.domain.car;

import java.util.Objects;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validLength(name);
        validEmpty(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalStateException("이름이 5글자를 넘어갔습니다.");
        }
    }

    private void validEmpty(String name) {

        if (isBlank(name)) {
            throw new IllegalStateException("이름이 존재하지 않습니다.");
        }
    }

    private static boolean isBlank(String str) {
        int strLen;

        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }

        for (int i = 0; i < strLen; i++) {
            if ((!Character.isWhitespace(str.charAt(i)))) {
                return false;
            }
        }
        return true;
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
