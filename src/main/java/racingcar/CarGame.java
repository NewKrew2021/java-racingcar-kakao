package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGame {

    private final Cars cars;
    private final int totalRound;
    private int currentRound = 0;

    private CarGame(Cars cars, int totalRound) {
        this.cars = cars;
        this.totalRound = totalRound;
    }

    public static CarGame of(Cars cars, int totalRound) {
        return new CarGame(cars, totalRound);
    }

    public void playRound() {
        currentRound++;
        updateCar();
    }

    private void updateCar() {
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();
        for (Car car : Cars.getCars()) {
            car.moveCarPosition(randomMovingStrategy);
        }
    }

    public ArrayList<String> getWinner() {
        int maxPosition = getMaxPosition();
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : Cars.getCars()) {
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

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : Cars.getCars()) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public boolean isFinished() {
        return totalRound == currentRound;
    }

    public List<Car> getCars() {
        return Cars.getCars();
    }
}
