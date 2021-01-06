package racingcar.domain;

import java.util.ArrayList;

public class RacingGame {
    private Car[] cars;

    public RacingGame(String[] names){
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

    public int getRandomNo() {
        return (int) (Math.random() * 10);
    }

    public void printCarsStatus() {
        for (Car car : cars) {
            car.printStatus();
        }
    }

    public ArrayList<String> getWinners() {
        ArrayList<String> winners = new ArrayList<>();
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = car.maxLocation(maxLocation);
        }

        for (int i = 0; i < cars.length; i++) {
            addWinner(winners, i, maxLocation);
        }

        return winners;
    }

    private void addWinner(ArrayList<String> winners, int idx, int maxLocation) {
        if (cars[idx].isMaxLocation(maxLocation)) {
            winners.add(cars[idx].getName());
        }
    }

    public Car[] getCars() {
        return this.cars;
    }

}