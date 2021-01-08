package racingcar.domain;

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
        if(!isLeftTryNumber()){
            throw new RuntimeException("더 이상 시도 횟수가 없어서 시도 하실 수 없습니다.");
        }
        this.tryNumber -= 1;
    }

    public boolean isLeftTryNumber() {
        return tryNumber > 0;
    }
}
