package racingcar;

public class Car {

    private int position;
    public static final int STEP = 1;

    public void goFront() {
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
}
