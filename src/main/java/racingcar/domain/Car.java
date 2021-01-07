package racingcar.domain;


public class Car {
    private Name name;
    private Location location = new Location();

    public Car(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.toString();
    }

    public int getLocation() {
        return location.getLocation();
    }

    public void move(int condition) {
        this.location.move(condition);
    }

    public String findWinner(int winnerLocation) {
        if (location.getLocation() == winnerLocation) {
            return name + " ";
        }
        return "";
    }

}
