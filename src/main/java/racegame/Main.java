package racegame;

import racegame.controller.GameContoller;

public class Main {

    public static void main(String[] args) {
        GameContoller gameManager = new GameContoller();
        gameManager.startGame();
    }

}
