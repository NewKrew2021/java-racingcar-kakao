package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;
    private Random random = new Random();

    private static final String SPLIT_DELIMITER = ",";
    private static final int RANGE = 10;

    public Cars(String namesText) {
        cars = new LinkedList<>();
        List<String> names = splitName(namesText);
        for (String name : names) {
            addCar(name);
        }
    }

    private List<String> splitName(String namesText) {
        return Arrays.asList(namesText.split(SPLIT_DELIMITER));
    }

    private void addCar(String name) {
        cars.add(new Car(name));
    }


    public List<Car> getCars() {
        return cars;
    }

    public List<String> getRaceWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();
        List<Car> winnerCars = getWinners(maxPosition);
        for (Car winnerCar : winnerCars) {
            winners.add(winnerCar.getName());
        }
        return winners;
    }

    private List<Car> getWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get().getPosition();
    }

    public void moveAll() {
        for (Car car : cars) {
            car.nextStep(random.nextInt(RANGE));
        }
    }
}
