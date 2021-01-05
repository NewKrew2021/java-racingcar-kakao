import domain.Cars;
import domain.RandomEngine;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingCarGame {
    public static void main(String[] args) {
        List<String> carNames = InputView.readNames();

        Cars cars = Cars.create(new RandomEngine(), carNames);

        int round = InputView.readRound();

        for (int i = 0; i < round; i++) {
            cars.moveCars();
            OutputView.printCars(cars.getCars());
        }

        OutputView.printWinnerCars(cars.findWinnerCars());
    }
}
