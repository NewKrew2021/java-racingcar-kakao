package racingcar.domain;

public class RapTime {
    private int rapTime;

    public RapTime(int rapTime) {
        if (rapTime < 1) {
            throw new IllegalArgumentException("Rap Time은 1이상의 수를 입력해 주세요");
        }
        this.rapTime = rapTime;
    }

    public void downTime() {
        if(isEnd()){
            throw new RuntimeException("레이싱이 이미 종료되었습니다.");
        }
        this.rapTime--;
    }

    public boolean isEnd() {
        return this.rapTime == 0;
    }
}
