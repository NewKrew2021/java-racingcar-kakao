import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final int roundNo;
    private final List<Car> cars;

    public RacingGame(int roundNo, List<Car> cars) {
        this.roundNo = roundNo;
        this.cars = cars;
    }

    public List<Car> getWinner() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
