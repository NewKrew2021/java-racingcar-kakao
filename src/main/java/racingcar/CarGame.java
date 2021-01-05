package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarGame {
    private final ArrayList<Car> carList;
    private final int totalRound;
    private int currentRound = 0;

    public ArrayList<Car> getCarList() {
        return carList;
    }

    public CarGame(ArrayList<Car> carList, int totalRound) {
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

    public boolean isFinished() {
        return totalRound == currentRound;
    }

    public ArrayList<String> getWinner() {
        int maxPosition = getMaxPosition();
        ArrayList<String> winners = new ArrayList<>();
        for(Car car : carList) {
            addWinner(car.getNameIfMatched(maxPosition),winners);
        }
        return winners;
    }

    private void addWinner(String name, ArrayList<String> winners) {
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

}
