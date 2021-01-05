package racingcar;

public class Car {
    private int position;
    private final String name;

    Car(String name){
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
