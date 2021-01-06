package racingcar;

import java.util.ArrayList;
import java.util.Random;

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
            car.move(getRandomNo());
        }
    }

    public int getRandomNo() {
        Random generator = new Random();
        return generator.nextInt(10);
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