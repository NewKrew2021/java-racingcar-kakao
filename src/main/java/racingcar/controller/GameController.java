package racingcar.controller;

import racingcar.domain.Car;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.Input;
import racingcar.view.Output;
import racingcar.text.Text;

import java.util.*;
import java.util.stream.Collectors;

public class GameController {
    private final RandomNumberGenerator randomNumberGenerator;
    private final List<Car> cars;
    private int gameTime;

    public GameController(){
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.cars = new ArrayList<>();
    }

    public void playGame(){
        Output.askCarsName();
        createCars(Input.getNames());

        Output.askGameTime();
        setGameTime(Input.getGameTime());

        simulateGame();
        endGame();
    }

    public void setGameTime(int gameTime) {
        this.gameTime = gameTime;
    }

    public void simulateGame(){
        Output.printSimulationResults(cars);
        for(int i = 0; i < gameTime; ++i){
            simulateCars();
            Output.printSimulationResults(cars);
        }
    }

    private void endGame() {
        Output.printWinner(getWinners(getCars()));
    }

    public static int getMaxLocation(List<Car> cars){
        OptionalInt max = cars.stream().mapToInt(Car::getLocation).max();
        if(max.isPresent()){
            return max.getAsInt();
        }
        throw new IllegalStateException(Text.ILLEGAL_STATE_NO_CAR);
    }

    public static List<String> getWinners(List<Car> cars){
        final int maxvalue = getMaxLocation(cars);
        return cars.stream()
                .filter(car -> car.isInLocation(maxvalue))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void simulateCars(){
        for(Car car: cars){
            car.tryForward(randomNumberGenerator.getRandomNumber());
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
