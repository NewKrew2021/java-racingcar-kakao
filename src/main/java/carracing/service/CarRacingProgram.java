package carracing.service;

import carracing.domain.Car;
import carracing.utility.RandomNumber;
import carracing.view.CarInfoPrint;
import carracing.view.CarRacingInfoPrint;
import carracing.view.RacingInfoScanner;

import java.util.*;
import java.util.stream.Collectors;

public class CarRacingProgram {
    private List<Car> carList;
    private int totalMoveCount;
    private int maxMoveDistance;

    private final int CAR_MOVING_THRESHOLD = 4;
    private final int CAR_CONDITION_BOUND = 10;
    private final String CAR_NAME_IDENTIFY_SYMBOL = ",";

    public CarRacingProgram(String carNames, int totalMoveCount){
        this.carList = insertCarNamesToCarList(carNames);
        this.totalMoveCount = totalMoveCount;
    }

    private List<Car> insertCarNamesToCarList(String carNames) {
        List<String> input = splitCarNames(carNames);

        return input.stream().map(Car::new).collect(Collectors.toList());
    }

    public boolean race(){
        CarRacingInfoPrint.printResultPhrase();
        for (int i = 0; i < totalMoveCount; i++) {
            playOneCycle();
        }

        CarRacingInfoPrint.printWinners(findRaceWinner());

        return true;
    }

    private void playOneCycle(){
        carList.forEach(item -> {
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
        carList.forEach(car -> compareMaxMoveDistanceToCarMoveCount(winnerList, car));

        return winnerList;
    }

    private void compareMaxMoveDistanceToCarMoveCount(List<String> winnerList, Car car){
        if(car.getPosition() == maxMoveDistance){
            winnerList.add(car.getName());
        }
    }

    public List<String> splitCarNames(String carNames){
        return Arrays.asList(carNames.split(CAR_NAME_IDENTIFY_SYMBOL));
    }

}
