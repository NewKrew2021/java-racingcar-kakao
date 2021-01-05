package racingcar;

import java.util.*;

public class GameManager {
    List<Car> cars;

    GameManager(){
        cars = new ArrayList<>();
    }

    public void createCars(List<String> nameList) {
        for(String str: nameList) {
            cars.add(new Car(str));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
