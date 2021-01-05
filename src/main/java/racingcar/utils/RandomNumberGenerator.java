package racingcar.utils;

public class RandomNumberGenerator {
    private static final int MAX = 10;

    public int getRandomNumber() {
        return (int)(Math.random() * MAX);
    }
}
