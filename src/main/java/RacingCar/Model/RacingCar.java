package RacingCar.Model;

public class RacingCar {
    static final int MIN_MOVABLE_NUMBER = 4;

    private String name;
    private int dist;


    public RacingCar(String name) {
        this.name = name;
        this.dist = 0;
    }


    public String getName() {
        return name;
    }

    public int move(int value) {
        if (isMove(value)) {
            return ++dist;
        }
        return dist;
    }

    private boolean isMove(int value) {
        return value >= MIN_MOVABLE_NUMBER;
    }

}
