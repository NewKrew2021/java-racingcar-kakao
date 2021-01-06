package domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    private static final Random random = new Random();

    private final List<Car> cars;
    private int maxPosition;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private void setMaxPosition() {
        cars.forEach(car -> maxPosition = Math.max(car.getPosition(), maxPosition));
    }

    private String getWinnerNameWithComma(Car car) {
        String s = "";
        if (car.getPosition() == this.maxPosition) {
            s += car.getName() + ", ";
        }
        return s;
    }

    public String returnWinnerString() {
        setMaxPosition();
        String s = cars.stream()
                .map(this::getWinnerNameWithComma)
                .reduce("", (total, value) -> total + value);
        return s.substring(0, s.length() - 2) + "가 최종 우승했습니다.";
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
