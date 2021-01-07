package racingcar.utils;

import java.util.Random;

public class RandomUtils {
    private static Random random = new Random();

    public static int generateRandomNumber(int range) {
        return random.nextInt(range);
    }
}
