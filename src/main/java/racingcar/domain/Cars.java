package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    private static final int NAME_LENGTH = 5;
    private static final String SPLIT_DELIMITER = ",";

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
        if (checkName(name)) {
            cars.add(new Car(name));
        }
    }

    private boolean checkName(String name) {
        return name.length() <= NAME_LENGTH;
    }

    public List<Car> getCars() {
        return cars;
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
