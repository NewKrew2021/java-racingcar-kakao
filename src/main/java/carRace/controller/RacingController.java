package carRace.controller;

import carRace.domain.Cars;
import carRace.domain.RacingGame;
import carRace.view.RacingGameUI;

public class RacingController {
    public static void main(String[] args) {
        Cars cars = Cars.fromNames(RacingGameUI.getNamesFromUser());
        RacingGame racingGame = new RacingGame(cars);
        racingGame.race(RacingGameUI.getNumOfRepeatFromUser());
        RacingGameUI.printWinners(cars.getWinners());
    }
}
