package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    List<Car> cars;

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = cars.stream().
                max(Comparator.comparing(Car::getCarInfo)).get().getCarInfo().getPosition();
        List<Car> winnerCars = cars.stream().
                filter(car -> car.getCarInfo().getPosition() == maxPosition).collect(Collectors.toList());

        for (Car winnerCar : winnerCars) {
            winners.add(winnerCar.getCarInfo().getName());
        }
        return winners;
    }
}
