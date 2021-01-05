package racingcar.domain;

import racingcar.CarNameInvalidException;

public class Car {
    private int position;
    private final String name;
    private static final int MOVEMENT = 1;
    private static final int NAME_MAX_LENGTH = 5;

    public Car(String name){
        if(!isValidName(name)) {
            throw new CarNameInvalidException("잘못된 이름입니다.");
        }
        this.name = name;
    }

    public void nextStep() {
        position += MOVEMENT;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private boolean isValidName(String name) {
        return name.length() <= NAME_MAX_LENGTH;
    }

}
