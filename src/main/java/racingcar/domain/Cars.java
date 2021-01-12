package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = registerCars(names);
    }

    private List<Car> registerCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void move(MoveDecisionStrategy moveDecisionStrategy) {
        for (Car car : this.cars) {
            car.move(moveDecisionStrategy.canMove());
        }
    }

    public List<String> getWinnerNames() {
        List<String> names = new ArrayList<>();
        for (Car car : getWinnerCars()) {
            names.add(car.getName());
        }
        return names;
    }

    private List<Car> getWinnerCars() {
        int farthestCarPosition = max(getFinalCarPositions());
        return this.cars.stream()
                        .filter(car -> isSameBoth(car.getPosition(), farthestCarPosition))
                        .collect(Collectors.toList());
    }

    private List<Integer> getFinalCarPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : this.cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }

    private int max(List<Integer> positions) {
        int maxVal = positions.get(0);
        for (int element : positions) {
            maxVal = Math.max(maxVal, element);
        }
        return maxVal;
    }

    private boolean isSameBoth(int a, int b) {
        return a == b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
