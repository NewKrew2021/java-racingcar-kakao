package racingcar.domain;

import java.util.Objects;

public class RandomNumber {
    private static final int RANDOM_SCOPE = 10;
    private static final int FORWARD_NUM = 4;
    private final int randomNo;

    public RandomNumber() {
        this((int) (Math.random() * RANDOM_SCOPE));
    }

    public RandomNumber(int randomNo) {
        if (randomNo < 0 || randomNo > 9) {
            throw new IllegalArgumentException("랜덤 숫자는 0~9이어야 합니다.");
        }
        this.randomNo = randomNo;
    }

    public boolean isMovable() {
        return this.randomNo > FORWARD_NUM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomNumber that = (RandomNumber) o;
        return randomNo == that.randomNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(randomNo);
    }
}
