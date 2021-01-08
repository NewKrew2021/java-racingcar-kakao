package racingcar.domain;

public class CarInfo {
    private final String name;
    private final int location;

    public CarInfo(String name, int location){
        this.name = name;
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
