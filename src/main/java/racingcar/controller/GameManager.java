package racingcar.controller;

import racingcar.domain.Car;
import racingcar.util.RandomNumber;
import racingcar.view.Output;

import java.util.*;

public class GameManager {
    private final List<Car> cars;
    private int gameTime;

    GameManager(){
        this.cars = new ArrayList<>();
    }

    public void setGameTime(int gameTime){
        this.gameTime = gameTime;
    }

    public void playGame(){
        Output.printResultStart();
        Output.printSimulationResult(cars);
        for(int i = 0; i < gameTime; ++i) {
            simulateCars();
            Output.printSimulationResult(cars);
        }
        Output.printWinner(getWinners());
    }

    private int getMaxLocation(){
        int max = -1;
        for(Car car: cars){
            max = Math.max(car.getLocation(), max);
        }
        return max;
    }

    private List<String> getWinners(){
        final int maxVal = getMaxLocation();
        List<String> winners = new ArrayList<>();
        cars.stream()
                .filter((car) -> car.getLocation() == maxVal)
                .forEach((car) -> winners.add(car.getName()));
        return winners;
    }

    private void simulateCars(){
        for(Car car: cars){
            car.tryForward(RandomNumber.getRandomNumber());
        }
    }

    public void createCars(List<String> nameList) {
        for(String name: nameList) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
