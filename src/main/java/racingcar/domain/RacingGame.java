package racingcar.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.max;

public class RacingGame {
    private final Cars cars;

    public RacingGame(String[] names){
        List<Car> cars = new ArrayList<>();
        for (String name: names) {
            cars.add(new Car(name));
        }
        this.cars = new Cars(cars);
    }

    public RacingGame(String[] names, int[] locations) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i], locations[i]));
        }
        this.cars = new Cars(cars);
    }

    public String race() {
        cars.moveCars();
        return cars.getCarsStatus();
    }

    public ArrayList<String> getWinners() {
        int maxLocation = cars.getMaxLocation();
        ArrayList<String> winners = cars.getCarNamesLocatedIn(maxLocation);
        return winners;
    }

}