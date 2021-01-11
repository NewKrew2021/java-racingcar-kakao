package carracing.domain;

import carracing.utility.RandomNumber;
import carracing.view.CarInfoPrint;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    private final int CAR_MOVING_THRESHOLD = 4;
    private final int CAR_CONDITION_BOUND = 10;

    private Cars(){
        cars = new ArrayList<>();
    }

    private Cars(List<Car> cars){
        this.cars = cars;
    }

    public static Cars makeNewCars(){
        return new Cars();
    }

    public static Cars makeNewCars_text(List<String> carNames){
        return new Cars(carNames.stream().map(Car::new).collect(Collectors.toList()));
    }

    public static Cars makeNewCars_cars(List<Car> cars){
        return new Cars(cars);
    }

    public void moveOrStopCars(){
        cars.forEach(car -> checkMovingCondition(car));
    }

    public void printCarsInfo(){
        cars.forEach(car -> CarInfoPrint.showCarInfo(car));
    }

    public List<Car> getCars(){
        return cars;
    }

    public Cars selectRaceWinners(){
        int maxDist = getMaxMoveDistance();

        return new Cars(cars.stream().filter(car -> maxDist == car.getPosition()).collect(Collectors.toList()));
    }

    private void checkMovingCondition(Car car){
        if(RandomNumber.getRandomNumber(CAR_CONDITION_BOUND) >= CAR_MOVING_THRESHOLD){
            car.go();
        }
    }

    private int getMaxMoveDistance(){
        int maxDist = 0;
        for (Car car : cars) {
            maxDist = Math.max(car.getPosition(), maxDist);
        }

        return maxDist;
    }
}
