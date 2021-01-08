package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        String[] parsingCarNames = splitCarNames(carNames);
        addCarName(parsingCarNames);
    }

    private String[] splitCarNames(String carNames) {
        return carNames
                .replace(" ", "")
                .split(",");
    }

    private void addCarName(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName, 0));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move(new RandomNumberMoveStrategy());
        }
    }
    
}