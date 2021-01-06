package racingcar;

import racingcar.controller.GameManager;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        Output.askCarsName();
        List<String> carsName = Input.getNames();
        gameManager.createCars(carsName);

        Output.askGameTime();
        int gameTime = Input.getGameTime();
        gameManager.setGameTime(gameTime);

        gameManager.playGame();
    }
}
