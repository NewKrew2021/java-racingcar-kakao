package racingcar;

import java.util.List;

public class CarMain {
    public static void main(String[] args) {
        List<String> carNames = CarView.parseCarName(CarView.writeCarName());
        CarGame game = CarGame.of(new Cars(carNames), CarView.writeRacingRound());

        CarView.printRoundStart();
        while (!game.isFinished()) {
            game.playRound();
            CarView.printRoundResult(game);
        }

        CarView.printWinnerCar(game.getWinner());
    }
}
