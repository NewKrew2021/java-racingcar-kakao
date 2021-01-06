package racingcar.controller;

import racingcar.domain.Car;
import racingcar.util.RandomNumber;
import racingcar.view.Output;

import java.util.*;

public class GameManager {
    private final List<Car> cars;
    private final int gameTime;

    public GameManager(){
        this(new ArrayList<>(), 0);
    }

    public GameManager(List<String> carNames, int gameTime) {
        this.gameTime = gameTime;
        this.cars = createCars(carNames);
    }

    public void playGame() {
        Output.printResultStart();
        Output.printSimulationResult(cars);
        for(int i = 0; i < gameTime; ++i) {
            move();
            Output.printSimulationResult(cars);
        }
        Output.printWinner(getWinners());
    }

    private int getMaxLocation() {
        int max = 0;
        for(Car car: cars){
            max = Math.max(max, car.getLocation());
        }
        return max;
    }

    private List<String> getWinners() {
        final int maxVal = getMaxLocation();
        List<String> winners = new ArrayList<>();
        cars.stream()
                .filter((car) -> car.getLocation() == maxVal)
                .forEach((car) -> winners.add(car.getName()));
        return winners;
    }

    private void move() {
        for(Car car: cars){
            car.tryForward(RandomNumber.getRandomNumber());
        }
    }

    private List<Car> createCars(List<String> nameList) {
        List<Car> cars = new ArrayList<>();
        for(String name: nameList) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
