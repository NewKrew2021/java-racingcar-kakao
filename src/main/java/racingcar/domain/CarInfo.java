package racingcar.domain;

public class CarInfo implements Comparable<CarInfo> {

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name + " : ");
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    @Override
    public int compareTo(CarInfo carInfo) {
        return this.position - carInfo.getPosition();
    }

}
