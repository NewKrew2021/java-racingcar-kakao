package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void printCurrentStatus() {
        for (Car car: this.cars) {
            System.out.printf("%-4s : ", car.getName());
            printStatusBar(car.getPosition());
        }
        System.out.println();
    }

    private void printStatusBar(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void moveOneRepeat() {
        for (Car car: this.cars) {
            car.move(createRandomNumber());
        }
    }

    private int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(9);
    }

    public List<String> winnerNames() {
        List<String> names = new ArrayList<>();
        for (Car car: whoWinners()) {
            names.add(car.getName());
        }
        return names;
    }

    private List<Car> whoWinners() {
        List<Car> winnerCars = new ArrayList<>();
        for(int carIndex: winnerCarsIndices()) {
            winnerCars.add(this.cars.get(carIndex));
        }
        return winnerCars;
    }

    private List<Integer> winnerCarsIndices() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < finalCarPositions().size(); i++) {
            result.add(checkFarthestCarIndex(i));
        }
        return result.stream()
                .filter(idx -> idx >= 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private List<Integer> finalCarPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : this.cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }

    private int checkFarthestCarIndex(int idx) {
        if (isSameBoth(max(finalCarPositions()), finalCarPositions().get(idx))) {
            return idx;
        }
        return -1;
    }

    private int max(List<Integer> positions) {
        int maxVal = positions.get(0);
        for (int element: positions) {
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
