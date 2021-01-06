package carracing.domain;

import carracing.view.CarInfoPrint;
import carracing.view.CarRacingInfoPrint;

import java.util.*;

public class CarRacingProgram {
    private List<Car> carList;
    private int totalMoveCount;
    private int maxMoveDistance;

    private final int CAR_NAME_LENGTH_THRESHOLD = 5;
    private final int CAR_MOVING_THRESHOLD = 4;
    private final int CAR_CONDITION_BOUND = 10;
    private final String CAR_NAME_IDENTIFY_SYMBOL = ",";

    public CarRacingProgram() {
        carList = new ArrayList<>();
    }

    public List<Car> insertCarNamesToCarList() {
        List<Car> carList = new ArrayList<>();
        List<String> input = splitCarNames(RacingInfoScanner.insertCarNames());
        for (int i = 0; i < input.size(); i++) {
            carList.add(new Car(input.get(i)));
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

        resultCarNames.stream().forEach(item ->{
            checkCarNameLength(item);
            isNotBlank(item);
        });

        return resultCarNames;
    }

    private boolean checkCarNameLength(String carName){
        if(carName.length() <= CAR_NAME_LENGTH_THRESHOLD)
            return true;

        throw new RuntimeException("이름의 길이가 " + CAR_NAME_LENGTH_THRESHOLD + "를 넘습니다.");
    }

    private boolean isNotBlank(String carName){
        if(!carName.isEmpty() || carName != null)
            return true;

        throw new RuntimeException("비어있거나 null인 문자열입니다.");
    }


}
