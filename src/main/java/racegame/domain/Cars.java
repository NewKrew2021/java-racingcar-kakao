package racegame.domain;

import racegame.util.RandomUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Winners getWinners() {
        int maxPosition = getMaxPosition();
        return new Winners(cars.stream()
                .filter(e -> e.isEqualPosition(maxPosition))
                .collect(Collectors.toList()));
    }

    private Integer getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public void allCarMoves(int value) {
        cars.forEach(e -> e.move(value));
    }

    public String getAllCarState() {
        return cars.stream()
                .map(Car::toString)
                .reduce("", (acc, cur) -> acc + cur + "\n");
    }

}
