package racingcar;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Output.askCarsName();
        List<String> carsName = Input.getNames();

        Output.askGameTime();
        int gameTime = Input.getGameTime();

        GameManager gameManager = new GameManager();
        gameManager.setGameTime(gameTime);
        gameManager.createCars(carsName);
        gameManager.playGame();
    }
}
