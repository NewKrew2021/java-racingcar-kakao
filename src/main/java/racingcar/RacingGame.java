package racingcar;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.max;

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

    public void moveCars() {
        for (Car car : cars) {
            car.move(Utils.getRandomNo());
        }
    }

    public String getCarsStatus() {
        String carsStatus = "";
        for (Car car : cars) {
            carsStatus += car.getStatus() + "\n";
        }
        return carsStatus;
    }

    public ArrayList<String> getWinners() {
        ArrayList<String> winners = new ArrayList<>();
        int maxLocation = getMaxLocation();

        for (int i = 0; i < cars.length; i++) {
            addWinner(winners, i, maxLocation);
        }

        return winners;
    }

    private int getMaxLocation() {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = max(maxLocation, car.getLocation());
        }
        return maxLocation;
    }

    private void addWinner(ArrayList<String> winners, int idx, int maxLocation) {
        if (isMaxLocation(cars[idx], maxLocation)) {
            winners.add(cars[idx].getName());
        }
    }

    private boolean isMaxLocation(Car car, int maxLocation) {
        return car.getLocation() == maxLocation;
    }

    public Car[] getCars() {
        return this.cars;
    }

}