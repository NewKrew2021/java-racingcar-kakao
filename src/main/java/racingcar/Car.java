package racingcar;

import java.util.Comparator;

public class Car {

    private int position = 1;
    public static final int STEP = 1;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    private void goFront() {
        position += STEP;
    }

    public int getPosition() {
        return position;
    }

    public int racing(int randomNum) {
        if (randomNum >= 4) {
            goFront();
        }
        return getPosition();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        stb.append(name).append(" : ");
        for (int i = 0; i < position; i++) {
            stb.append("-");
        }
        return stb.toString();
    }
}
