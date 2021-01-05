package racingCar;

public class Car {

    private final String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void goForward(Integer value) {
        if (value >= 4) this.position++;
    }

    public Integer getPosition() {
        return position;
    }
}
