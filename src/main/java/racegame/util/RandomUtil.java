package racegame.util;

import java.util.Random;

public class RandomUtil {
    private static Random random = new Random();

    public static Integer getRandomValue() {
        return random.nextInt(10);
    }
}
