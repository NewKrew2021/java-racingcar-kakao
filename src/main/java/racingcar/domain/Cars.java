package racingcar.domain;

import racingcar.exceptions.InvalidCarNameException;
import racingcar.exceptions.InvalidPositionException;
import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    private static final String DEFAULT_SPLIT_DELIMITER = ",";
    private static final int RANGE = 10;

    private List<Car> cars;
    private Winners winners;

    public Cars(String inputCarNames) {
        List<String> names = splitName(inputCarNames);
        cars = new ArrayList<>();
        for (String name : names) {
            addCar(name);
        }
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

    public List<CarInfo> getStatus() {
        List<CarInfo> carInfos = new ArrayList<>();
        for (Car car : cars) {
            carInfos.add(car.getCarInfo());
        }
        return carInfos;
    }

    public void raceAll() {
        for (Car car : cars) {
            car.move(RandomUtils.generateRandomNumber(RANGE));
        }
    }

    public List<String> findWinners() {
        return winners.findWinners();
    }

    private List<String> splitName(String str) {
        return Arrays.asList(str.split(DEFAULT_SPLIT_DELIMITER));
    }

}
