package racinggame;

import domain.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    List<Car> cars;
    public Cars(List<Car> cars){
        this.cars = cars;
    }

    public void moveAll(MoveStrategy strategy){
        for (Car car: this.cars) {
            car.move(strategy);
        }
    }

    public List<Car> getHeads(){
        Collections.sort(cars);
        int maxPosition = cars.get(0).getPosition();
        return cars.stream()
                .filter((car)->car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
