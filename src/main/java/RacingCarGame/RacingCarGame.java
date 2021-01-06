package RacingCarGame;

import Car.Cars;
import UI.InputView;
import UI.OutputView;

import java.util.List;

public class RacingCarGame {
    public static void main(String[] args) {
        List<String> carNames = InputView.readNames();

        Cars cars = new Cars(carNames);

        int round = InputView.readRound();

        for (int i = 0; i < round; i++) {
            cars.moveCars();
            OutputView.printCars(cars.getCars());
        }

        OutputView.printWinnerCars(cars.findLeadingCars());
    }
}
