package carRace.controller;

import carRace.view.GameUI;
import carRace.utils.RandomGenerator;
import carRace.domain.Cars;

import java.util.List;

public class GameController {

    public void run(){
        Cars candidates = GameUI.getCarsFromUser();
        race(candidates, GameUI.getNumOfRepeatFromUser());
        GameUI.printWinners(candidates.getWinners());
    }

    private void race(Cars candidates, int repeatNumber) {

        GameUI.printStartMessage();
        RandomGenerator randomGenerator = new RandomGenerator();

        for (int i = 0; i < repeatNumber; i++) {
            List<Integer> movingNumbers = randomGenerator.getIntegerList(candidates.size());
            candidates.moveAllCarsAccordingTo(movingNumbers);
            GameUI.printAllCars(candidates);
        }
    }
}