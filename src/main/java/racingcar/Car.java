package racingcar;

public class Car {
    private String name;
    private int distance;

    public Car(String name, int distance) {
        if (name.length() > 5)
            throw new InvalidCarNameException("이름은 5자 이하만 가능합니다.");

        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move(CarStatus status) {
        if (status == CarStatus.Go)
            this.distance++;
    }
}
