package racingcar.domain;

import java.util.Objects;

public class TryNumber{
    private int tryNumber;

    public TryNumber(int tryNumber) {
        if(isNegativeValue(tryNumber)){
            throw new IllegalArgumentException("시도 횟수는 음수가 될 수 없습니다.");
        }
        this.tryNumber = tryNumber;
    }

    private boolean isNegativeValue(int value) {
        return value < 0;
    }

    public void useTryNumber() {
        this.tryNumber -= 1;
    }

    public boolean isLeftTryNumber() {
        return tryNumber > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryNumber tryNumber1 = (TryNumber) o;
        return tryNumber == tryNumber1.tryNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryNumber);
    }
}
