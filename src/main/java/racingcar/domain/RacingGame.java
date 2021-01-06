package racingcar.domain;

import java.util.ArrayList;

public class RacingGame {
    private Car[] cars;

    public RacingGame(String[] names) {
        cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
    }

    public RacingGame(String[] names, int[] locations) {
        cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i], locations[i]);
        }
    }

    public static String[] stringToNames(String input) {
        return input.split(",");
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(getRandomNo());
        }
    }

    private int getRandomNo() {
        return (int) (Math.random() * 10);
    }

    public void printCarsStatus() {
        for (Car car : cars) {
            car.printStatus();
        }
    }
}