package racingcar.domain;

import java.util.*;

public class RacingGame {

    private Cars cars;
    private GameStatus gameStatus;

    public RacingGame(String inputCarNames) {
        this(inputCarNames, 0);
    }

    public RacingGame(String inputCarNames, int gameCount) {
        cars = new Cars(inputCarNames);
        this.gameStatus = new GameStatus(gameCount);
    }

    public void racing() {
        if(!isGameEnd()) {
            cars.raceAll();
            gameStatus.playGame();
        }
    }

    public boolean isGameEnd() { return gameStatus.isGameEnd(); }

    public List<CarInfo> getCarInfos() {
        return cars.getCarInfos();
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }

}
