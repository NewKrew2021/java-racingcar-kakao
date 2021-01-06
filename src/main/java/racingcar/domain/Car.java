package racingcar.domain;

public class Car {

    private Position position;
    private final Name name;

    public Car(String name){
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public CarInfo getCarInfo() {
        return new CarInfo(name.getName(), position.getPosition());
    }

    public void move(int currentSpeed) {
        position.nextStep(currentSpeed);
    }

}
