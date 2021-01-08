package racingcar.domain;

public class TryNo {

    private int tryNo;

    public TryNo(int tryNo) {
        validate(tryNo);
        this.tryNo = tryNo;
    }

    private void validate(int tryNo) {
        if (tryNo <= 0) {
            throw new IllegalArgumentException("시도 회수는 1이상이어야 합니다.");
        }
    }

    public void decrease() {
        this.tryNo -= 1;
    }

    public boolean isZero() {
        return this.tryNo == 0;
    }
}
