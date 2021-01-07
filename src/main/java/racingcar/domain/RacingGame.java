package racingcar.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.max;

public class RacingGame {
    public static final int UPPER_BOUND = 10;
    private final List<Car> cars;

    public RacingGame(String[] names){
        Car[] cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        this.cars = Arrays.asList(cars);
    }

    public RacingGame(String[] names, int[] locations) {
        Car[] cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i], locations[i]);
        }
        this.cars = Arrays.asList(cars);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(Utils.getRandomNo(UPPER_BOUND));
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

        for (int i = 0; i < cars.size(); i++) {
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
        if (isMaxLocation(cars.get(idx), maxLocation)) {
            winners.add(cars.get(idx).getName());
        }
    }

    private boolean isMaxLocation(Car car, int maxLocation) {
        return car.getLocation() == maxLocation;
    }

    public List<Car> getCars() {
        return this.cars;
    }

}