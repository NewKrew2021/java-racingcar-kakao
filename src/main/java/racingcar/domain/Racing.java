package racingcar.domain;

import java.util.*;
import java.util.stream.IntStream;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Racing racing = (Racing) o;
        return Objects.equals(cars, racing.cars) && Objects.equals(tryNumber, racing.tryNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, tryNumber);
    }
}
