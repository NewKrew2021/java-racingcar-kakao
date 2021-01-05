package racingcar.domain;

public class Car {
    private int position;
    private final String name;
    private static final int MOVEMENT = 1;

    public Car(String name){
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

}
