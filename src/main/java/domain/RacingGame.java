package domain;

import java.util.List;

public class RacingGame {
    private static final int MIN_TOTAL_ROUND = 1;
    private static final int INITIAL_ROUND = 1;

    private final Cars cars;
    private final int totalRound;
    private int currentRound;

    private RacingGame(Cars cars, int totalRound, int currentRound) {
        validate(totalRound);

        this.cars = cars;
        this.totalRound = totalRound;
        this.currentRound = currentRound;
    }

    private void validate(int totalRound) {
        if (totalRound < MIN_TOTAL_ROUND) {
            throw new IllegalArgumentException("라운드는 양의 정수여야 합니다.");
        }
    }

    public static RacingGame initialize(Engine engine, List<String> names, int round) {
        return new RacingGame(Cars.create(engine, names), round, INITIAL_ROUND);
    }

    public boolean isEnd() {
        return currentRound > totalRound;
    }

    public void moveCars() {
        if (isEnd()) {
            throw new IllegalStateException("종료된 게임입니다.");
        }

        cars.moveCars();
        currentRound++;
    }

    public List<Car> findWinnerCars() {
        return cars.findWinners();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getTotalRound() {
        return totalRound;
    }

    public int getCurrentRound() {
        return currentRound;
    }
}
