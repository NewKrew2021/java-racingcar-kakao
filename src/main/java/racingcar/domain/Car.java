package racingcar.domain;

import racingcar.util.StringUtil;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int THRESHOLD = 4;
    private final String name;
    private int location;

    public static Car from(String name) {
        return new Car(name,0);
    }

    public static Car of(String name, int location) {
        return new Car(name, location);
    }

    private Car(String name, int location) {
        validate(name);
        this.name = name;
        this.location = location;
    }

    private void validate(String name) {
        if (StringUtil.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("한대 이상의 자동차를 입력해주세요.");
        }
        if (StringUtil.isOverMaxLength(name, MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException("차 이름은 5자 이하여야 합니다.");
        }
    }

    public void move(int num) {
        if (isMoveFoward(num)) {
            this.location++;
        }
    }

    private boolean isMoveFoward(int number) {
        return number >= THRESHOLD;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public CarInfo getInfo(){
        return new CarInfo(this.name, this.location);
    }
}
