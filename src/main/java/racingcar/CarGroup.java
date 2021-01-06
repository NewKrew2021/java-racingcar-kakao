package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {

    private final List<Car> carGroup;

    public static CarGroup createCarGroupWithName(List<String> names){
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, 0));
        }
        return new CarGroup(cars);
    }

    public CarGroup(List<Car> carGroup) {
        this.carGroup = carGroup;
    }

    public void moveAll() {
        for(Car car : carGroup){
            car.move();
        }
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for(Car car : carGroup) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public CarGroup getWinner() {
        int maxPosition = getMaxPosition();
        List<String> winnerNames = new ArrayList<>();
        List<Car> winnerCars = carGroup.stream()
                .filter((car) -> car.isMatched(maxPosition))
                .collect(Collectors.toList());
        return new CarGroup(winnerCars);
    }

    public List<String> getWinnerName() {
        return this.getWinner().getCarGroup().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCarGroup() {
        return carGroup;
    }


}
