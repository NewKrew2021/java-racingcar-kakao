package domain;

public class Car {

    private final int STOP_VALUE = 3;
    private final CarName name;
    private final Position position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new Position();
    }

    public boolean goOrStop(int i) {
        return i > STOP_VALUE;
    }

    public void move(boolean isMove) {
        if (isMove) {
            this.position.increase();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.toString();
    }

    @Override
    public String toString() {
        return this.name + " : " + this.position;
    }
}
