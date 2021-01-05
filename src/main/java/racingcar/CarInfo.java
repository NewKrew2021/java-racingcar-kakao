package racingcar;

public class CarInfo {
    private final int position;
    private final String name;

    public CarInfo(String name, int position) {
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
