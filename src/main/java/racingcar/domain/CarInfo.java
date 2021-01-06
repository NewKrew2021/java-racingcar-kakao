package racingcar.domain;

public class CarInfo implements Comparable<CarInfo> {

    private final Position position;
    private final Name name;

    public CarInfo(String name, int position) {
        this.position = new Position(position);
        this.name = new Name(name);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
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

    @Override
    public int compareTo(CarInfo carInfo) {
        return position.getPosition() - carInfo.getPosition();
    }

}
