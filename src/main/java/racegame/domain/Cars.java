package racegame.domain;

import racegame.util.RandomUtil;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Winners getWinners() {
        int maxPosition = getMaxPosition();
        return new Winners(cars.stream()
                .filter(e -> e.getPosition().getPosition() == maxPosition)
                .collect(Collectors.toList()));
    }

    public Integer getMaxPosition() {
        return cars.stream()
                .mapToInt(e -> e.getPosition().getPosition())
                .max()
                .getAsInt();
    }

    public void allCarMoves() {
        cars.forEach(e -> e.move(RandomUtil.getRandomValue()));
    }

    public String getAllCarState() {
        return cars.stream().map(Car::toString)
                .reduce("", (acc, cur) -> acc + cur + "\n");
    }

}
