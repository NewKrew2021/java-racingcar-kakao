package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGame {

    private final CarGroup carGroup;
    private final int totalRound;
    private int currentRound = 0;

    public CarGame(List<String> carNames, int totalRound) {
        this.carGroup = CarGroup.createCarGroupWithName(carNames);
        this.totalRound = totalRound;
    }

    public void playRound() {
        updateCar();
        currentRound++;
    }

    private void updateCar() {
        carGroup.moveAll();
    }

    public List<String> getWinnerName() {
        return carGroup.getWinnerName();
    }

    public boolean isFinished() {
        return totalRound == currentRound;
    }

    public List<Car> getCarList() {
        return carGroup.getCarGroup();
    }
}
