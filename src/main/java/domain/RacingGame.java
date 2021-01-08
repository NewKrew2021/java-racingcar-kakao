package domain;

import java.util.List;

public class RacingGame {
    private final int finalRound;
    private final Cars cars;
    private int curRound;

    public RacingGame(int finalRound, String carNames) {
        this.finalRound = finalRound;
        this.cars = new Cars(carNames);
        this.curRound = 0;
    }

    public boolean isEnd() {
        return curRound == finalRound;
    }

    public void playRound() {
        cars.play();
        curRound++;
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
