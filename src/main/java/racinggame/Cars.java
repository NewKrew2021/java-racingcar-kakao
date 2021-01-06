package racinggame;

import domain.Car;

import java.util.List;

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
}
