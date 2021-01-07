package racingcar.domain;

import java.util.Random;

public class RandomConditionValueStrategy implements ConditionValueStrategy {

    @Override
    public int getValue() {
        return createRandomNumber();
    }

    private int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(9);
    }
}
