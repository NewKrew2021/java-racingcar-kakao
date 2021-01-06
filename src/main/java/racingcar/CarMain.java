package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarMain {
    public static void main(String[] args) {
        List<String> carNames = CarView.parseCarName(CarView.writeCarName());
        int racingRound = CarView.writeRacingRound();

        CarGame game = new CarGame(carNames, racingRound);

        CarView.printRoundStart();

        while(!game.isFinished()){
            game.playRound();
            CarView.printRoundResult(game);
        }

        CarView.printWinnerCar(game.getWinnerName());
    }
}
