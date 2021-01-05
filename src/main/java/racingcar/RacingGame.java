package racingcar;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
    private List<Car> cars;

    private static final int RANGE = 10;
    private static final int SPEED = 4;

    RacingGame(String str) {
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
        return name.length() <= 5;
    }

    public List<CarInfo> racing() {
        List<CarInfo> carInfos = new ArrayList<>();
        for (Car car : cars) {
            moveCar(car);
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
