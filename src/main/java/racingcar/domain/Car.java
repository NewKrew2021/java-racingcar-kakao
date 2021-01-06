package racingcar.domain;

public class Car {
    private static final int SPEED = 4;

    private final Position position;
    private final Name name;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void nextStep(int number) {
        if (isCarGo(number)) {
            position.move();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    public boolean isCarGo(int number) {
        return number >= SPEED;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name.getName() + " : ");
        for (int i = 0; i < position.getPosition(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
