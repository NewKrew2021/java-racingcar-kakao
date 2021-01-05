package racingcar;

import java.util.stream.IntStream;

public class Car {
    private int position;
    private String name;

    private final int MAX_RANDOM_VALUE = 9;
    private final int MIN_RANDOM_VALUE = 0;
    private final int THRESHOLD_RANDOM_VALUE = 4;

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

    public void move(int randomValue){
        if (randomValue < THRESHOLD_RANDOM_VALUE) return;
        this.position++;
    }
}
