package racingcar.domain;

import racingcar.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars (List<Car> cars){
        this.cars = cars;
    }

    public static Cars of(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> findWinners() {
        int maxLocation = getMaxLocation();
        return this.cars.stream()
                .filter(c -> isMaxLocation(c, maxLocation))
                .collect(Collectors.toList());

    }

    private int getMaxLocation() {
        return this.cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .getAsInt();
    }

    private boolean isMaxLocation(Car car, int maxLocation) {
        return car.getLocation() == maxLocation;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(getRandomNo());
        }
    }

    private int getRandomNo() {
        return (int) (Math.random() * 10);
    }
}
