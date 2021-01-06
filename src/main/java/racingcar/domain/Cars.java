package racingcar.domain;

import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    private static final String DEFAULT_SPLIT_DELIMITER = ",";

    private List<Car> cars;
    private WinnersFinder winnersFinder;

    public Cars(String inputCarNames) {
        List<String> names = splitName(inputCarNames);
        cars = new ArrayList<>();
        for (String name : names) {
            addCar(name);
        }
        winnersFinder = new WinnersFinder();
    }

    private void addCar(String name) {
        cars.add(new Car(name));
    }

    public List<CarInfo> getCarInfos() {
        List<CarInfo> carInfos = new ArrayList<>();
        for (Car car : cars) {
            carInfos.add(car.getCarInfo());
        }
        return carInfos;
    }

    public void raceAll() {
        for (Car car : cars) {
            car.move(new RandomMovingStrategy());
        }
    }

    public List<String> findWinners() {
        return winnersFinder.findWinners(getCarInfos());
    }

    private List<String> splitName(String str) {
        return Arrays.asList(str.split(DEFAULT_SPLIT_DELIMITER));
    }

}
