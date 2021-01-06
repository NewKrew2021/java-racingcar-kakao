package carRace;

public class GameController {

    public void run(){
        CarSet candidates = GameUI.getCarsFromUser();
        race(candidates, GameUI.getNumOfRepeatFromUser());
        GameUI.printWinners(candidates.getWinners());
    }

    private void race(CarSet candidates, int repeatNumber) {
        GameUI.printStartMessage();
        for (int i = 0; i < repeatNumber; i++) {
            candidates.moveAllCars(candidates.genRandomNumbers());
            GameUI.printAllCars(candidates);
        }
    }
}