package Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        for (String carName : carNames) {
            addCar(new Car(carName));
        }
    }

    public Cars() {

    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(new CarManager().movable());
        }
    }

    public List<Car> findLeadingCars() {
        Car leadingCar = findLeadingCar();

        return cars.stream()
                .filter(car -> car.isAtSamePositionWith(leadingCar))
                .collect(Collectors.toList());
    }

    private Car findLeadingCar() {
        Car leadingCar = cars.get(0);

        for (Car car : cars) {
            leadingCar = findForwardingCarBetween(leadingCar, car);
        }

        return leadingCar;
    }

    private Car findForwardingCarBetween(Car car1, Car car2) {
        if (car2.isForwardThan(car1)) {
            return car2;
        }
        return car1;
    }

    public List<Car> getCars() {
        return cars;
    }

}
