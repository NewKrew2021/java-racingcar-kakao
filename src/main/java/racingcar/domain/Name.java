package racingcar.domain;

import racingcar.CarNameInvalidException;

public class Name {

    private final String name;
    private static final int NAME_MAX_LENGTH = 5;
    private static final String LENGTH_OVER_ERROR_MESSAGE = "잘못된 형식의 이름입니다. 입력에서 제외합니다 : ";

    public Name(String name) {
        if(name.length() > NAME_MAX_LENGTH) {
            throw new CarNameInvalidException(LENGTH_OVER_ERROR_MESSAGE);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

}