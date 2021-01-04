package RacingCar;

public class RacingCar {
    private String name;

    public RacingCar() {

    }

    public RacingCar(String name) {
        this.name = name;
    }

    public boolean isNameLengthValid() {
        return this.name.length() <= 5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
