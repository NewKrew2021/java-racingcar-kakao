package racingcar.domain;

public class CarPosition {

    private int position;

    public CarPosition() {
        this(0);
    }

    public CarPosition(int position) {
        if(isNegativeValue(position)){
            throw new IllegalArgumentException("position 이 음수가 될 수 없습니다");
        }
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }

    public boolean isNegativeValue(int value){
        return value < 0;
    }

    public void forward() {
        this.position += 1;
    }
}
