package racingcar.domain;

import racingcar.exception.InvalidCarNameException;

public class Name {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidCarNameException("자동차의 이름은 비어있을 수 없습니다.");
        }

        if (name.length() > MAX_LENGTH) {
            throw new InvalidCarNameException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
