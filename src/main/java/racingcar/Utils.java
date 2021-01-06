package racingcar;

import java.util.Random;

public class Utils {
    public static int getRandomNo() {
        Random generator = new Random();
        return generator.nextInt(10);
    }

    public static boolean isBlank(String input) {
        return input == null || input.equals("");
    }

}
