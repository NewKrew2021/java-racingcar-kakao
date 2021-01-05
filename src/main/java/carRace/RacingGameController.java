package carRace;

public class RacingGameController {

    public void run(){
        Cars cars = RacingGameUI.getCarsFromUser();
        race(RacingGameUI.getNumOfRepeatFromUser(), cars);
        RacingGameUI.printWinners(cars.getWinners());
    }

    private void race(int n, Cars cars) {
        RacingGameUI.printStartMessage();
        for (int i = 0; i < n; i++) {
            cars.moveAllCars(cars.getCarsRandomNumber());
            RacingGameUI.printAllCars(cars);
        }
    }
}