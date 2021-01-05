package carRace;

public class GameController {

    public void run(){
        CarSet carSet = GameUI.getCarsFromUser();
        race(GameUI.getNumOfRepeatFromUser(), carSet);
        GameUI.printWinners(carSet.getWinners());
    }

    private void race(int n, CarSet carSet) {
        GameUI.printStartMessage();
        for (int i = 0; i < n; i++) {
            carSet.moveAllCars(carSet.getCarsRandomNumber());
            GameUI.printAllCars(carSet);
        }
    }
}