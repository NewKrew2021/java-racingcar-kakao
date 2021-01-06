package racingcar.domain;

import racingcar.exception.InvalidCarNameLengthException;

import java.util.Objects;

public class Name {
    private final int MAX_NAME_LENGTH = 5;
    private String name;

    public Name(String name){
        if (name.length() > MAX_NAME_LENGTH || name.isBlank()){
            throw new InvalidCarNameLengthException("길이를 5이하로 설정해주세요");
        }
        this.name = name;
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
