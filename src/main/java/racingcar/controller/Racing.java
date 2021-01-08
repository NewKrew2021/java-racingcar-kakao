package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TryNumber;

import java.util.*;

public class Racing {

    private Cars cars;
    private TryNumber tryNumber;

    public Racing(String carNames, int tryNumber){
        createCars(splitNames(carNames));
        this.tryNumber = new TryNumber(tryNumber);
    }

    public void oneRoundRacing() {
        cars.moveAll();
        tryNumber.useTryNumber();
    }

    public void createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.cars = new Cars(cars);
    }

    public List<String> splitNames(String str) {
        return new ArrayList<>(Arrays.asList(str.split(",")));
    }

    public Cars getCars(){
        return this.cars;
    }

    public boolean canRace() {
        return tryNumber.isLeftTryNumber();
    }

}
