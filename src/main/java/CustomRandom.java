import java.util.Random;

public class CustomRandom {
    private static final int RANGE = 10;
    private static final Random random = new Random();
    public static int nextInt() {
        return random.nextInt(RANGE);
    }
}
