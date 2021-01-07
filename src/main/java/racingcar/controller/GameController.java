package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class GameController {
    private final Cars cars = new Cars();
    private int gameTime;

    public void playGame() {
        Output.askCarsName();
        setGameCars(Input.getNames());

        Output.askGameTime();
        setGameTime(Input.getGameTime());

        simulateGame();
        endGame();
    }

    public Cars getGameCars() {
        return cars;
    }

    public void setGameTime(int gameTime) {
        this.gameTime = gameTime;
    }

    public void setGameCars(List<String> carArgs) {
        cars.createCars(carArgs);
    }

    public void simulateGame() {
        Output.printSimulationResults(cars);
        for (int i = 0; i < gameTime; ++i) {
            cars.simulate();
            Output.printSimulationResults(cars);
        }
    }

    private void endGame() {
        Output.printWinner(cars.getMaxNames());
    }

}
