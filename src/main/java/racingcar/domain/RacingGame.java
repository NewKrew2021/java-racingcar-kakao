package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;

    private static final int RANGE = 10;
    private static final int SPEED = 4;
    private static final int NAME_LENGTH = 5;

    public RacingGame(String str) {
        cars = new ArrayList<>();
        List<String> names = splitName(str);
        for (String name : names) {
            addCar(name);
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

    private boolean checkName(String name) {
        return name.length() <= NAME_LENGTH;
    }

    public void race() {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    public List<CarInfo> getRaceStatus() {
        List<CarInfo> carInfos = new ArrayList<>();
        for (Car car : cars) {
            carInfos.add(new CarInfo(car.getName(), car.getPosition()));
        }
        return carInfos;
    }

    public boolean isCarGo(int number) {
        return number >= SPEED;
    }

    private void moveCar(Car car) {
        Random random = new Random();
        if (isCarGo(random.nextInt(RANGE))) {
            car.nextStep();
        }
    }

    public List<String> getRaceWinners() {
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
