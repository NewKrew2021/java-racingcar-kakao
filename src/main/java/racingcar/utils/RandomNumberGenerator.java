package racingcar.utils;

import racingcar.io.Text;

public class RandomNumberGenerator {
    private static final int MAX = 10;
    private static final int MIN_RANDOM_NUM = 0;
    private static final int MAX_RANDOM_NUM = 9;

    public int getRandomNumber() {
        int random = (int)(Math.random() * MAX);
        validateRandomNumber(random);
        return random;
    }

    private void validateRandomNumber(int random){
        if(isInvalid(random)){
            throw new IllegalArgumentException(Text.ILLEGAL_RANDOM_NUMBER);
        }
    }

    private boolean isInvalid(int random) {
        return random > MAX_RANDOM_NUM || random < MIN_RANDOM_NUM;
    }
}
