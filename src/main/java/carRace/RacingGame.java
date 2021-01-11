package carRace;

public class RacingGame {

    private final MovingStrategy strategy;
    private final Cars cars;

    public RacingGame(Cars cars) {
        this.strategy = new RandomStrategy();
        this.cars = cars;
    }

    public void race(int n) {
        RacingGameUI.printStartMessage();
        for (int i = 0; i < n; i++) {
            cars.moveAllCars(strategy);
            RacingGameUI.printAllCars(cars);
        }
    }
}
