package racingcar;

public class RandomNumber {
    static final int MAX = 10;

    public static int getRandomNumber() {
        return (int)(Math.random() * MAX);
    }
}
