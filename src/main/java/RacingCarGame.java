public class RacingCarGame {
    public static void main(String[] args) {
        Cars cars = new Cars();
        cars.createCarsByNames(InputView.readNames());

        int round = InputView.readRound();
        for (int i = 0; i < round; i++) {
            cars.tryMove();
            OutputView.printCars(cars.getCars());
        }
        OutputView.printWinnerCars(cars.findWinners());
    }
}
