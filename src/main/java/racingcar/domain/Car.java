package racingcar.domain;

import racingcar.CarNameInvalidException;

public class Car {

    private static final int MOVEMENT = 1;
    private static final int SPEED = 4;

    private int position;
    private final Name name;

    public Car(String name){
        this.name = new Name(name);
    }

    Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public CarInfo getCarInfo() {
        return new CarInfo(this.name.getName(), this.position);
    }

    public void nextStep(int currentSpeed) {
        if(isCarGo(currentSpeed)) {
            position += MOVEMENT;
        }
    }

    public boolean isCarGo(int currentSpeed) {
        return currentSpeed >= SPEED;
    }

}
