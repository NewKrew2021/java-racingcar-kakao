package racingcar.domain;

import java.util.Objects;

public class TryNo {
    private final int END_NO = 0;
    private final int STEP = 1;
    private final int tryNo;

    public TryNo(int tryNo) {
        if (tryNo < 0) {
            throw new IllegalArgumentException("시도 횟수는 음수가 될 수 없습니다.");
        }
        this.tryNo = tryNo;
    }

    protected TryNo tryRacing() {
        return new TryNo(tryNo - STEP);
    }

    public boolean isEnd() {
        return tryNo == END_NO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryNo tryNo1 = (TryNo) o;
        return tryNo == tryNo1.tryNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryNo);
    }
}
