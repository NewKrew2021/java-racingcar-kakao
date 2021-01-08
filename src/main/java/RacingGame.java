import domain.Car;
import domain.Cars;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final int finalRound;
    private final Cars cars;
    private int curRound;

    public RacingGame(int finalRound, String carNames) {
        this.finalRound = finalRound;
        this.cars = new Cars(carNames);
        this.curRound = 0;
    }

    public boolean isEnd() {
        return curRound == finalRound;
    }

    public void playRound() {
        cars.play();
        curRound++;
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }

    protected List<Car> getCars() {
        return cars.getCars();
    }

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int roundNo = InputView.getRoundNo();
        RacingGame game = new RacingGame(roundNo, carNames);

        OutputView.printExecResultSentence();
        while (!game.isEnd()) {
            game.playRound();
            OutputView.printCars(game.getCars());
        }
        OutputView.printWinners(game.getWinners());
    }

}
