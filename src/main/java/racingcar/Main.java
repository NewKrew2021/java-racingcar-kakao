package racingcar;

import racingcar.controller.GameManager;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();

        gameManager.playGame();
    }
}
