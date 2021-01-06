package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final int NAME_LENGTH = 5;
    private final String name;

    public Name(String name){
        if(name.length() > NAME_LENGTH){
            throw new IllegalArgumentException("이름은 5자를 넘기면 안됩니다.");
        }
        if(name.isEmpty()){
            throw new IllegalArgumentException("이름을 입력해 주세요");
        }
        this.name = name;
    }

    public String getName() {
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
