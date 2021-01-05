import domain.Car;
import domain.CarManager;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingCarGame {
    public static void main(String[] args) {
        List<String> carNames = InputView.readNames();

        CarManager carManager = new CarManager();

        for (String carName : carNames) {
            carManager.pushCar(new Car(carName));
        }

        int round = InputView.readRound();

        for (int i = 0; i < round; i++) {
            carManager.moveCars();
            OutputView.printCars(carManager.getCars());
        }

        OutputView.printWinnerCars(carManager.findWinnerCars());
    }
}
