package carRace;

public class RacingController {
    public static void main(String[] args) {
        Cars cars = Cars.fromNames(RacingGameUI.getNamesFromUser());
        RacingGame racingGame = new RacingGame(cars);
        racingGame.race(RacingGameUI.getNumOfRepeatFromUser());
        RacingGameUI.printWinners(cars.getWinners());
    }
}
