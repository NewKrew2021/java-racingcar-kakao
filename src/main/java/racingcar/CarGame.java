package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarGame {
    private final ArrayList<Car> carList;
    private final int totalRound;
    private int currentRound = 0;

    public CarGame(ArrayList<Car> carList, int totalRound){
        this.carList = carList;
        this.totalRound = totalRound;
    }


    public static ArrayList<String> parseCarName(String text){
        return new ArrayList<String>(Arrays.asList(text.split(",")));
    }

    public static void validateCarName(ArrayList<String> nameList) throws IllegalStateException {
        for (String name : nameList) {
            testLength(name);
        }
    }

    private static void testLength(String name){
        if(name.length() > 5){
            throw new IllegalStateException();
        }
    }

    public void playRound() {
        while(!isFinished()){
            currentRound++;
            updateCar();
        }
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

    private void addWinner(String name, ArrayList<String> winners){
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
