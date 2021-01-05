import domain.Cars;
import domain.RandomEngine;
import view.InputView;
import view.OutputView;

public class RacingCarGame {
    public static void main(String[] args) {
        Cars cars = createCars();

        moveForRounds(cars);

        OutputView.printWinnerCars(cars.findWinnerCars());
    }

    private static Cars createCars() {
        return Cars.create(new RandomEngine(), InputView.readNames());
    }

    private static void moveForRounds(Cars cars) {
        int round = InputView.readRound();
        for (int i = 0; i < round; i++) {
            cars.moveCars();
            OutputView.printCars(cars.getCars());
        }
    }
}
