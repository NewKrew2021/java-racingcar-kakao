package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static  List<Car> cars;

    public Cars (){
        cars = new ArrayList<>();
    }

    public Cars (List<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.of(carName, 0));
        }
    }

    public static List<Car> getCars() {
        return cars;
    }

    public static void add(Car car){
        cars.add(car);
    }

}
