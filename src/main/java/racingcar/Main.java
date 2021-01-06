package racingcar;

import racingcar.controller.GameManager;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Output.askCarsName();
        List<String> carsName = Input.getNames();

        Output.askGameTime();
        int gameTime = Input.getGameTime();
        GameManager gameManager = new GameManager(carsName, gameTime);

        gameManager.playGame();
    }
}
