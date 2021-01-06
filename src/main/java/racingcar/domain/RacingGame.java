package racingcar.domain;

import racingcar.exceptions.InvalidCarNameException;
import racingcar.exceptions.InvalidPositionException;

import java.util.*;

public class RacingGame {

    private static final int RANGE = 10;
    private static final String DEFAULT_SPLIT_DELIMITER = ",";

    private Random random;
    private List<Car> cars;
    private Winners winners;

    public RacingGame(String inputCarNames) {
        random = new Random();
        cars = new ArrayList<>();
        List<String> names = splitName(inputCarNames);
        for (String name : names) {
            addCar(name);
        }
        winners = new Winners(cars);
    }

    public RacingGame(List<Car> cars) {
        this.cars = cars;
        winners = new Winners(cars);
    }

    private void addCar(String name) {
        try {
            cars.add(new Car(name));
        } catch (InvalidCarNameException carNameInvalidException) {
            carNameInvalidException.printErrorMessage(name);
        } catch (InvalidPositionException invalidPositionException) {
            invalidPositionException.printErrorMessage();
        }
    }

    private List<String> splitName(String str) {
        return Arrays.asList(str.split(DEFAULT_SPLIT_DELIMITER));
    }

    public void racing() {
        for (Car car : cars) {
            car.move(generateRandomNumber());
        }
    }

    public List<CarInfo> getStatus() {
        List<CarInfo> carInfos = new ArrayList<>();
        for (Car car : cars) {
            carInfos.add(car.getCarInfo());
        }
        return carInfos;
    }

    private int generateRandomNumber() {
        return random.nextInt(RANGE);
    }

    public List<String> findWinners() {
        return winners.findWinners();
    }

}
