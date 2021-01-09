package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.GameTime;
import racingcar.util.RandomNumber;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.*;
import java.util.stream.Collectors;

public class GameManager {
    private List<Car> cars;
    private GameTime gameTime;

    public void playGame() {
        carInput();
        gameTimeInput();
        Output.printResultStart();
        Output.printSimulationResult(cars);
        while (!gameTime.isEnd()) {
            gameTime.process();
            move();
            Output.printSimulationResult(cars);
        }
        Output.printWinner(getWinners());
    }

    private void carInput() {
        Output.askCarsName();
        cars = createCars(Input.getNames());
    }

    private void gameTimeInput() {
        Output.askGameTime();
        gameTime = new GameTime(Input.getGameTime());
    }

    private int getMaxLocation() {
        int max = 0;
        for (Car car : cars) {
            max = car.maxLocation(max);
        }
        return max;
    }

    private List<String> getWinners() {
        final int maxVal = getMaxLocation();
        List<String> winners = new ArrayList<>();
        cars.stream()
                .filter((car) -> car.isEqualLocation(maxVal))
                .forEach((car) -> winners.add(car.getName()));
        return winners;
    }

    private void move() {
        cars.stream().forEach(car -> car.tryForward(RandomNumber.getRandomNumber()));
    }

    private List<Car> createCars(List<String> nameList) {
        return nameList.stream().map(Car::new).collect(Collectors.toList());
    }

    List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
