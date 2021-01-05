package carRace;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public void run() {
        Cars cars = RacingGameUI.getCarsFromUser();
        race(RacingGameUI.getNumOfRepeatFromUser(), cars);
        RacingGameUI.printWinners(cars.getWinners());
    }

    private void race(int n, Cars cars) {
        RacingGameUI.printStartMessage();
        for (int i = 0; i < n; i++) {
            cars.moveAllCars(makeRandomNumber(cars.getNumOfCars()));
            RacingGameUI.printAllCars(cars);
        }
    }

    private List<Integer> makeRandomNumber(int numOfCars) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numOfCars; i++){
            numbers.add((int)(Math.random() * 10));
        }

        return numbers;
    }
}