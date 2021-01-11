package racingcar.domain.game;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarGame {

    private final Cars cars;
    private Round round;

    private CarGame(Cars cars, int totalRound) {
        this.cars = cars;
        this.round = new Round(totalRound);
    }

    public static CarGame of(List<String> carNames, int totalRound) {
        List<Car> startLineCars = new ArrayList<>();
        for (String carName : carNames) {
            startLineCars.add(Car.of(carName, 0));
        }
        return new CarGame(new Cars(startLineCars), totalRound);
    }

    public void playRound(MovingStrategy movingStrategy) {
        round.playCurrentRound();
        cars.moveCars(movingStrategy);
    }

    public List<String> getGameWinners() {
        return cars.getFarthestCarNames();
    }

    public boolean isFinished() {
        return round.isFinished();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
