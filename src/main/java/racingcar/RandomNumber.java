package racingcar;

import java.util.Random;

public class RandomNumber {
    public static int generate() {
        return new Random().nextInt(10);
    }
}
