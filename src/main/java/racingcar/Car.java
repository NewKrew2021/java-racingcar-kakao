package racingcar;

public class Car {

    private int position;
    public static final int STEP = 1;
    private String name;

    public Car() {
    }

    public Car(String name) {
        setName(name);
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
