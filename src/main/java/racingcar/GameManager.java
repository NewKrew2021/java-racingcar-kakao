package racingcar;

import java.util.*;

public class GameManager {
    private final RandomNumber randomNumber;
    private final List<Car> cars;
    private int gameTime;

    GameManager(){
        this.randomNumber = new RandomNumber();
        this.cars = new ArrayList<>();
    }

    public void setGameTime(int gameTime){
        this.gameTime = gameTime;
    }

    public void playGame(){
        for(int i = 0; i <= gameTime; ++i){
            Output.printSimulationResult(cars);
            simulateCars();
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
        final int maxval = getMaxLocation();
        List<String> winners = new ArrayList<>();
        cars.stream()
                .filter((car) -> car.getLocation() == maxval)
                .forEach((car) -> winners.add(car.getName()));
        return winners;
    }

    private void simulateCars(){
        for(Car car: cars){
            car.tryForward(randomNumber.getRandomNumber());
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
