package domain;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    private static final Random random = new Random();

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private int getMaxPosition() {
        return Collections.max(
                cars.stream()
                        .map(Car::getPosition)
                        .collect(Collectors.toList()));
    }

    public String returnWinnerString() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(","))
                + "가 최종 우승했습니다.";
    }

    public void race() {
        cars.forEach(car -> car.move(car.goOrStop(makeRandomValue())));
    }

    private int makeRandomValue() {
        return random.nextInt(10);
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList())
                .stream()
                .reduce("", (total, value) -> total + value + "\n");
    }
}
