package racingcar.domain.game;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;

public class CarGame {

    private final Cars cars;
    private Round round;

    private CarGame(Cars cars, int totalRound) {
        this.cars = cars;
        this.round = new Round(totalRound);
    }

    public static CarGame of(Cars cars, int totalRound) {
        return new CarGame(cars, totalRound);
    }

    public void playRound(MovingStrategy movingStrategy) {
        round.playCurrentRound();
        cars.moveCars(movingStrategy);
    }

    public List<String> getGameWinners() {
        return cars.getFarthestCarNames();
    }

    public boolean isFinished() {
        return round.isRoundFinished();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
