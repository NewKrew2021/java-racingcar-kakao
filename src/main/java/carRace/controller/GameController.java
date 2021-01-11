package carRace.controller;

import carRace.utils.RandomGenerator;
import carRace.domain.Cars;
import carRace.view.Input;
import carRace.view.Output;

import java.util.List;

public class GameController {

    public static Cars generateCars() {
        return Input.getCarsFromUser();
    }

    public static void race(Cars candidates) {
        int repeatNumber = Input.getNumOfRepeatFromUser();

        Output.printStartMessage();
        RandomGenerator randomGenerator = new RandomGenerator();

        for (int i = 0; i < repeatNumber; i++) {
            List<Integer> movingNumbers = randomGenerator.getIntegerList(candidates.size());
            candidates.moveAllCarsAccordingTo(movingNumbers);
            Output.printAllCars(candidates);
        }

        Output.printWinners(candidates.getWinners());
    }

    /* 사용자는 GameController의 메소드만을 호출하므로 이곳에 main을 위치시켜 봤습니다. */
    public static void main(String[] args) {
        Cars car = generateCars();
        race(car);
    }
}