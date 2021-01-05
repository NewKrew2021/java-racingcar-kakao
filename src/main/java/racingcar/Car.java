package racingcar;

import java.util.stream.IntStream;

public class Car {

    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition(){
        return this.position;
    }

    public void move(int value) {
        if(value > 9 || value < 0) throw new RuntimeException();
        if (value >= 4) {
            this.position++;
        }
    }
}
