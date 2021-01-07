package racingcar;

import java.util.List;

public class CarMain {
    public static void main(String[] args) {
        List<String> carNames = CarInputView.parseCarName(CarInputView.writeCarName());
        int racingRound = CarInputView.writeRacingRound();

        CarGame game = new CarGame(carNames, racingRound);

        CarOutputView.printRoundStart();

        while(!game.isFinished()){
            game.playRound();
            CarOutputView.printRoundResult(game);
        }

        CarOutputView.printWinnerCar(game.getWinnerName());
    }
}
