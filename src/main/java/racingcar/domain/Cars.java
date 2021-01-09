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
        List<Car> winnerCars = new ArrayList<>();
        for(int carIndex : winnerCarsIndices()) {
            winnerCars.add(this.cars.get(carIndex));
        }
        return winnerCars;
    }

    private List<Integer> winnerCarsIndices() {
        List<Integer> finalCarPositions = getFinalCarPositions();
        int farthestCarPosition = max(finalCarPositions);
        List<Integer> carIndices = getSamePositionIndices(farthestCarPosition, finalCarPositions);
        return carIndices;
    }

    private List<Integer> getFinalCarPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : this.cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }

    private List<Integer> getSamePositionIndices(int position, List<Integer> carPositions) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < carPositions.size(); i++) {
            if (isSameBoth(position, carPositions.get(i))) {
                indices.add(i);
            }
        }
        return indices;
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
