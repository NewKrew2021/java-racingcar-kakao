package racingcar;

import racingcar.controller.GameController;
import racingcar.view.Output;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        try {
            gameController.playGame();
        } catch(Exception e){
            Output.printError(e);
        }
    }
}
