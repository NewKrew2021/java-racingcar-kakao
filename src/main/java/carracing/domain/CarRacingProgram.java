package carracing.domain;

import carracing.view.CarInfoPrint;
import carracing.view.CarRacingInfoPrint;

import java.util.*;

public class CarRacingProgram {
    private List<Car> carList;
    private int totalMoveCount;
    private int maxMoveDistance;

    private final int CAR_MOVING_THRESHOLD = 4;
    private final int CAR_CONDITION_BOUND = 10;

    public CarRacingProgram() {
        carList = new ArrayList<>();
    }

    public static List<Car> insertCarNamesToCarList() {
        List<Car> carList = new ArrayList<>();
        String[] input = RacingInfoScanner.insertCarNames().split(",");
        for (int i = 0; i < input.length; i++) {
            carList.add(new Car(input[i]));
        }

        return carList;
    }

    public void race(){
        CarRacingInfoPrint.printCarListInputPhrase();
        carList = insertCarNamesToCarList();

        CarRacingInfoPrint.printRaceCountPhrase();
        totalMoveCount = RacingInfoScanner.insertRaceTryCount();

        CarRacingInfoPrint.printResultPhrase();
        for (int i = 0; i < totalMoveCount; i++) {
            playOneCycle();
        }

        CarRacingInfoPrint.printWinners(findRaceWinner());
    }



    public void playOneCycle(){
        carList.stream().forEach(item -> {
            checkMovingCondition(item);
            CarInfoPrint.showCarInfo(item);
        });

        CarRacingInfoPrint.printBlankLine();
    }

    public void checkMovingCondition(Car car){
        if(RandomNumber.getRandomNumber(CAR_CONDITION_BOUND) >= CAR_MOVING_THRESHOLD){
            maxMoveDistance = Math.max(maxMoveDistance, car.go());
        }
    }

    public List<String> findRaceWinner(){
        List<String> winnerList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            compareMaxMoveDistanceToCarMoveCount(winnerList, i);
        }

        return winnerList;
    }

    public void compareMaxMoveDistanceToCarMoveCount(List<String> winnerList, int carIndex){
        if(carList.get(carIndex).getPosition() == maxMoveDistance){
            winnerList.add(carList.get(carIndex).getName());
        }
    }


}
