import java.util.Random;

public class MyRandom {
    private final int RANGE = 10;

    public int nextInt() {
        return new Random().nextInt(RANGE);
    }
}
