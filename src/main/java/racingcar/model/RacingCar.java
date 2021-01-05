package racingcar.model;

public class RacingCar {

    private static final int MIN_MOVABLE_NUMBER = 4;

    private int dist;

    private final String name;

    public RacingCar(String name) {
        this.name = name;
        this.dist = 0;
    }

    public int move(int value) {
        if (isMove(value)) {
            return ++this.dist;
        }
        return this.dist;
    }

    private boolean isMove(int value) {
        return value >= MIN_MOVABLE_NUMBER;
    }

    public void printDist() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name).append(" : ");
        for (int i = 0; i < this.dist; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());
    }

    public String getName() {
        return this.name;
    }

    public int getDist() {
        return this.dist;
    }

}
