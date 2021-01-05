package carRace;

public class RacingGameController {

    public void run(){
        CarSet carSet = RacingGameUI.getCarsFromUser();
        race(RacingGameUI.getNumOfRepeatFromUser(), carSet);
        RacingGameUI.printWinners(carSet.getWinners());
    }

    private void race(int n, CarSet carSet) {
        RacingGameUI.printStartMessage();
        for (int i = 0; i < n; i++) {
            carSet.moveAllCars(carSet.getCarsRandomNumber());
            RacingGameUI.printAllCars(carSet);
        }
    }
}