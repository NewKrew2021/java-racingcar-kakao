import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public void createCarsByNames(List<String> names) {
        names.forEach(name -> push(new Car(name)));
    }

    public void push(Car car) {
        cars.add(car);
    }

    public void tryMove() {
        cars.forEach(car -> car.moveOrNot(NumberUtil.generateRandomNumber()));
    }

    public List<Car> findWinners() {
        Car winner = findWinner();
        return cars.stream()
                .filter(car -> car.isAtSamePositionWith(winner))
                .collect(Collectors.toList());
    }

    private Car findWinner() {
        Car maxPositionCar = cars.get(0);
        return cars.stream()
                .reduce(maxPositionCar, Cars::findForwardingCarBetween);
    }

    private static Car findForwardingCarBetween(Car car1, Car car2) {
        if (car2.isForwardThan(car1)) {
            return car2;
        }
        return car1;
    }

    public List<Car> getCars() {
        return cars;
    }
}
