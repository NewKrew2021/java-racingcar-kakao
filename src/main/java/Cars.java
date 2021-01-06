import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public Cars getWinners() {
        int maxPosition = getMaxPosition();
        return new Cars(cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList()));
    }

    public void play() {
        for (Car car : cars) {
            car.runWithCondition(CustomRandom.nextInt());
            System.out.println(car);
        }
    }

    @Override
    public String toString() {
        String[] names = new String[cars.size()];
        for (int i = 0; i < names.length; ++i) {
            names[i] = cars.get(i).getName();
        }
        return String.join(", ", names);
    }
}
