package racingcar;

import racingcar.domain.game.CarGame;
import racingcar.domain.game.MovingStrategy;
import racingcar.domain.game.RandomMovingStrategy;
import racingcar.view.CarInput;
import racingcar.view.CarOutput;

public class CarMain {
    public static void main(String[] args) {
        CarGame game = CarGame.of(CarInput.writeCarName(), CarInput.writeRacingRound());
        MovingStrategy movingStrategy = new RandomMovingStrategy();

        CarOutput.printRoundStart();
        while (!game.isFinished()) {
            game.playRound(movingStrategy);
            CarOutput.printRoundResult(game);
        }

        CarOutput.printWinnerCar(game.getGameWinners());
    }
}
