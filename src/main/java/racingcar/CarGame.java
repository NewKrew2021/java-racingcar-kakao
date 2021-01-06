package racingcar;

import java.util.ArrayList;

public class CarGame {

    private final ArrayList<Car> carList;
    private final int totalRound;
    private int currentRound = 0;

    private CarGame(ArrayList<Car> carList, int totalRound) {
        this.carList = carList;
        this.totalRound = totalRound;
    }

    public static CarGame of(ArrayList<Car> carList, int totalRound){
        return new CarGame(carList,totalRound);
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

    public boolean isFinished() {
        return totalRound == currentRound;
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }
}
