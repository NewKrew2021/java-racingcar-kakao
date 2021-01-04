package RacingCar;

public class RacingCar {
    private String name;
    private int dist;


    public RacingCar() {
        this.dist = 0;
    }

    public RacingCar(String name) {
        this.name = name;
        this.dist = 0;
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
