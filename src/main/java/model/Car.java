package model;

import java.util.Random;

public class Car implements Comparable<Car> {
    private static final int MOVE_THRESHOLD = 4;
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;
    private final Random rand;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.position = position;
        rand = new Random();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isEqualPosition(Car car) {
        return car.position == position;
    }

    public void move() {
        move(generateRandomNumber());
    }

    public void move(int number) {
        if (number > MOVE_THRESHOLD) position++;
    }

    private int generateRandomNumber() {
        return rand.nextInt(10);
    }

    @Override
    public int compareTo(Car o) {
        if (o.position > position) return 1;
        if (o.position < position) return -1;
        return 0;
    }
}
