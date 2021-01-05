package racingcar.domain;

import racingcar.domain.Car;
import racingcar.domain.CarInfo;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;

    private static final int RANGE = 10;
    private static final int SPEED = 4;
    private static final int NAME_MAX_LENGTH = 5;

    public RacingGame(String str) {
        cars = new ArrayList<>();
        List<String> names = splitName(str);
        for (String name : names) {
            addCar(name);
        }
    }

    public RacingGame(List<Car> cars) {
        for (Car car : cars) {
            addCar(car);
        }
    }

    private List<String> splitName(String str) {
        return Arrays.asList(str.split(","));
    }

    private void addCar(String name) {
        if (checkName(name)) {
            cars.add(new Car(name));
        }
    }

    private void addCar(Car car) {
        if (checkName(car.getName())) {
            cars.add(car);
        }
    }

    private boolean checkName(String name) {
        return name.length() <= NAME_MAX_LENGTH;
    }

    public void racing() {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    public List<CarInfo> getStatus() {
        List<CarInfo> carInfos = new ArrayList<>();
        for (Car car : cars) {
            carInfos.add(new CarInfo(car.getName(), car.getPosition()));
        }
        return carInfos;
    }

    boolean isCarGo(int number) {
        return number >= SPEED;
    }

    void moveCar(Car car) {
        Random random = new Random();
        if (isCarGo(random.nextInt(RANGE))) {
            car.nextStep();
        }
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = cars.stream().max(Comparator.comparing(Car::getPosition)).get().getPosition();
        List<Car> winnerCars = cars.stream().
                filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());

        for (Car winnerCar : winnerCars) {
            winners.add(winnerCar.getName());
        }
        return winners;
    }
}
