package racingcar;

import java.util.stream.IntStream;

public class Car {
    private int position;
    private String name;

    private final int MAX_VALUE = 9;
    private final int MIN_VALUE = 0;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }

    public void move(int value) {
        if(value > MAX_VALUE || value < MIN_VALUE) throw new RuntimeException();
        if (value >= 4) {
            this.position++;
        }
    }
}
