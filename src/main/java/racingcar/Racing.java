package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private List<Car> cars;

    public Racing(String input) {
        cars = new ArrayList<>();
        String[] carName = input.split(",");

        for (int i = 0; i < carName.length; i++) {
            cars.add(new Car(carName[i], 0));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public CarStatus goStop(int number) {
        if (number >= 4)
            return CarStatus.Go;

        return CarStatus.Stop;
    }

    public void moveAll(List<Integer> numbers) {
        for (int i = 0; i < cars.size(); i++) {
            CarStatus status = goStop(numbers.get(i));
            cars.get(i).move(status);
        }
    }

    public List<Car> getWinners() {
        int maxDistance = getMaxDistance();

        return cars.stream()
                .filter(o1 -> o1.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    public int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
}
