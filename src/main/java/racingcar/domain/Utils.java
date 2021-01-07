package racingcar.domain;

import java.util.Random;

public class Utils {
    public static int getRandomNo() {
        final int UPPER_BOUND = 10;
        Random generator = new Random();
        return generator.nextInt(UPPER_BOUND);
    }

    public static boolean isBlank(String input) {
        return input == null || input.equals("");
    }

}
