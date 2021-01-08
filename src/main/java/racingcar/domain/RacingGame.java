package racingcar.domain;


import java.util.ArrayList;
import java.util.List;


public class RacingGame {
    private final Cars cars;

    public RacingGame(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.cars = new Cars(cars);
    }

    public RacingGame(List<String> names, List<Integer> locations) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            cars.add(new Car(names.get(i), locations.get((i))));
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