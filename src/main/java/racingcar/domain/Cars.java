package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;
    private Random random = new Random();

    private static final String SPLIT_DELIMITER = ",";
    private static final int RANGE = 10;

    public Cars(String namesText) {
        cars = splitName(namesText).stream().map(Car::new).collect(Collectors.toList());
    }

    private List<String> splitName(String namesText) {
        return Arrays.asList(namesText.split(SPLIT_DELIMITER));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
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
                .filter(car -> car.equalsPosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = car.getMax(max);
        }
        return max;
    }

    public void moveAll() {
        for (Car car : cars) {
            car.nextStep(random.nextInt(RANGE));
        }
    }
}
