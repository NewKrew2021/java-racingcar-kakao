package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGame {

    private final List<Car> carList;
    private final int totalRound;
    private int currentRound = 0;

    public CarGame(List<Car> carList, int totalRound) {
        this.carList = carList;
        this.totalRound = totalRound;
    }

    public void playRound() {
        currentRound++;
        updateCar();
    }

    private void updateCar() {
        for(Car car : carList){
            car.updateCarPosition(car.getDistance(car.makeRandomNumber()));
        }
    }

    public List<String> getWinner() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for(Car car : carList) {
            addWinner(car.getNameIfMatched(maxPosition),winners);
        }
        return winners;
    }

    private void addWinner(String name, List<String> winners) {
        if(!name.isEmpty()){
            winners.add(name);
        }
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for(Car car : carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public boolean isFinished() {
        return totalRound == currentRound;
    }

    public List<Car> getCarList() {
        return carList;
    }
}
