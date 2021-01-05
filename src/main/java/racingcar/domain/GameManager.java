package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;
import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.io.Text;

import java.util.*;

public class GameManager {
    private final RandomNumberGenerator randomNumberGenerator;
    private final List<Car> cars;
    private int gameTime;

    public GameManager(){
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.cars = new ArrayList<>();
    }

    public void playGame(){
        setCars();
        setGameTime();
        simulateGame();
        endGame();
    }

    private void setCars() {
        Output.askCarsName();
        List<String> carsName = Input.getNames();
        createCars(carsName);
    }

    private void setGameTime() {
        Output.askGameTime();
        gameTime = Input.getGameTime();
    }

    public void simulateGame(){
        Output.printSimulationResults(cars);
        for(int i = 0; i < gameTime; ++i){
            simulateCars();
            Output.printSimulationResults(cars);
        }
    }

    private void endGame() {
        Output.printWinner(getWinners());
    }

    private int getMaxLocation(){
        OptionalInt max = cars.stream().mapToInt(Car::getLocation).max();
        if(max.isPresent()){
            return max.getAsInt();
        }
        throw new IllegalStateException(Text.ILLEGAL_STATE_NO_CAR);
    }

    private List<String> getWinners(){
        final int maxvalue = getMaxLocation();
        List<String> winners = new ArrayList<>();
        cars.stream()
                .filter((car) -> car.getLocation() == maxvalue)
                .forEach((car) -> winners.add(car.getName()));
        return winners;
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
