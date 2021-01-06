package racingcar.domain;

public class Car {
    private static final int SPEED = 4;

    private int position;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void nextStep(int number) {
        if (isCarGo(number)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isCarGo(int number) {
        return number >= SPEED;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name + " : ");
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
