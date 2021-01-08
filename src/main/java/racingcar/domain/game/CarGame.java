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

    public static CarGame of(Cars cars, int totalRound) {
        return new CarGame(cars, totalRound);
    }

    public void playRound(MovingStrategy movingStrategy) {
        round.playCurrentRound();
        cars.moveCars(movingStrategy);
    }

    public ArrayList<String> getWinner() {
        int maxPosition = cars.maxCarPosition();
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : cars.getCars()) {
            addWinner(getNameIfMatched(car, maxPosition), winners);
        }
        return winners;
    }

    private String getNameIfMatched(Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            return car.getName();
        }
        return "";
    }

    private void addWinner(String name, ArrayList<String> winners) {
        if (!name.isEmpty()) {
            winners.add(name);
        }
    }

    public boolean isFinished() {
        return round.isRoundFinished();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
