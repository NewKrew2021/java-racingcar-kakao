package racingcar.domain;

import java.util.Objects;
import java.util.Random;

public class RandomNumber {

    private final int randomNo;

    private final int MAX_RANDOM_VALUE = 9;
    private final int MIN_RANDOM_VALUE = 0;
    private final int THRESHOLD_FORWARD_VALUE = 4;

    public RandomNumber(){
        Random rand = new Random();
        this.randomNo = rand.nextInt((MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1)) + MIN_RANDOM_VALUE;
    }

    public RandomNumber(int randomNo) {
        if(randomNo > MAX_RANDOM_VALUE || randomNo < MIN_RANDOM_VALUE){
            throw new IllegalArgumentException("범위를 벗어나는 random 값이 들어 왔습니다.");
        }
        this.randomNo = randomNo;
    }

    public boolean isMovableRandomNumber() {
        return randomNo >= THRESHOLD_FORWARD_VALUE;
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
