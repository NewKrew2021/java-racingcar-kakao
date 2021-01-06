package carRace;

public class RacingGame {

    public void run() {
        Cars cars = Cars.fromNames(RacingGameUI.getNamesFromUser());
        race(RacingGameUI.getNumOfRepeatFromUser(), cars);
        RacingGameUI.printWinners(cars.getWinners());
    }

    private void race(int n, Cars cars) {
        RacingGameUI.printStartMessage();
        for (int i = 0; i < n; i++) {
            cars.moveAllCars();
            RacingGameUI.printAllCars(cars);
        }
    }


}