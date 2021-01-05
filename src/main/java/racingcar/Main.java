package racingcar;

import racingcar.domain.GameManager;
import racingcar.io.Output;

public class Main {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        try {
            gameManager.playGame();
        } catch(Exception e){
            Output.printError(e);
        }
    }
}
