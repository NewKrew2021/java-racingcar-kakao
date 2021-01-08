package carracing.service;

import carracing.domain.Car;
import carracing.utility.RandomNumber;
import carracing.view.CarInfoPrint;
import carracing.view.CarRacingInfoPrint;
import carracing.view.RacingInfoScanner;

import java.util.*;

public class CarRacingProgram {
    private List<Car> carList = new ArrayList<>();
    private int totalMoveCount;
    private int maxMoveDistance;

    private final int CAR_MOVING_THRESHOLD = 4;
    private final int CAR_CONDITION_BOUND = 10;
    private final String CAR_NAME_IDENTIFY_SYMBOL = ",";

    private List<Car> insertCarNamesToCarList() {
        List<Car> carList = new ArrayList<>();
        List<String> input = splitCarNames(RacingInfoScanner.insertCarNames());
        for (int i = 0; i < input.size(); i++) {
            carList.add(new Car(input.get(i)));
        }

        return carList;
    }

    public void race(){
        carList = insertCarNamesToCarList();

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

    private void checkMovingCondition(Car car){
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

    private void compareMaxMoveDistanceToCarMoveCount(List<String> winnerList, int carIndex){
        if(carList.get(carIndex).getPosition() == maxMoveDistance){
            winnerList.add(carList.get(carIndex).getName());
        }
    }

    public List<String> splitCarNames(String carNames){
        List<String> resultCarNames = Arrays.asList(carNames.split(CAR_NAME_IDENTIFY_SYMBOL));

        return resultCarNames;
    }

}
