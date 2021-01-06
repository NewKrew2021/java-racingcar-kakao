package racingcar.domain;

import java.util.*;

public class RacingGame {
    private Random random = new Random();
    private Cars cars;

    private static final int RANGE = 10;

    public RacingGame(String namesText) {
        cars = new Cars(namesText);

    }

    public void race() {
        for (Car car : cars.getCars()) {
            moveCar(car);
        }
    }

    public List<Car> getRaceStatus() {
        return cars.getCars();
    }

    private void moveCar(Car car) {
        car.nextStep(random.nextInt(RANGE));
    }

    public List<String> getRaceWinners() {
        return cars.getRaceWinners();
    }
}
