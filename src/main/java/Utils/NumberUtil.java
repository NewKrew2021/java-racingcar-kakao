package Utils;

import java.util.Random;

public class NumberUtil {
    private static final Random random = new Random();

    public static int generateRandomNumber(int bound) {
        return random.nextInt(bound);
    }
}
