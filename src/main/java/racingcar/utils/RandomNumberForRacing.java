package racingcar.utils;

import java.util.Random;

public class RandomNumberForRacing {

    private static final Random rand = new Random();

    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MIN_RANDOM_VALUE = 0;


    public static int getRandomNumberForRacing(){
        return rand.nextInt((MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1)) + MIN_RANDOM_VALUE;
    }
}
