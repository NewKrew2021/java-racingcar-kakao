package racingcar.domain;

public class Car {
    private int position;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void nextStep() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
