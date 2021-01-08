package racingcar.domain;

import java.util.Random;

public class Utils {
    public static int getRandomNo(int upper_bound) {
        Random generator = new Random();
        return generator.nextInt(upper_bound);
    }

    public static boolean isBlank(String input) {
        return input == null || input.equals("");
    }

}
