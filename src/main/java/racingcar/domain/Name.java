package racingcar.domain;

import racingcar.CarNameInvalidException;
import racingcar.utils.StringUtils;

import java.util.Objects;

public class Name {

    private final String name;
    private static final String LENGTH_OVER_ERROR_MESSAGE = "최대 길이를 초과한 이름입니다. 입력에서 제외합니다 : ";
    private static final String EMPTY_NAME_ERROR_MESSAGE = "이름은 공백이 될 수 없습니다. 입력에서 제외합니다";

    public Name(String name) {
        if(StringUtils.isBlank(name)) {
            throw new CarNameInvalidException(EMPTY_NAME_ERROR_MESSAGE);
        }
        if(StringUtils.isNameOverMaxLength(name)) {
            throw new CarNameInvalidException(LENGTH_OVER_ERROR_MESSAGE);
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