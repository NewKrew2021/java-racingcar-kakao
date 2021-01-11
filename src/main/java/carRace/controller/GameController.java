package carRace.controller;

import carRace.domain.MovingStrategy;
import carRace.domain.RandomMovingStrategy;
import carRace.domain.Cars;
import carRace.view.Input;
import carRace.view.Output;

public class GameController {

    public static Cars generateCars() {
        return new Cars(Input.getCarNamesFromUser());
    }

    public static void race(Cars candidates, MovingStrategy strategy) {
        int repeatNumber = Input.getNumOfRepeatFromUser();
        Output.printStartMessage();

        for (int i = 0; i < repeatNumber; i++) {
            candidates.moveAllCarsAccordingTo(strategy);
            Output.printAllCars(candidates.getCarInformations());
        }

        Output.printWinners(candidates.getWinningCarNames());
    }

    /* 사용자는 GameController의 메소드만을 호출하므로 이곳에 main을 위치시켜 봤습니다. */
    public static void main(String[] args) {
        Cars car = generateCars();
        race(car, new RandomMovingStrategy());
    }
}