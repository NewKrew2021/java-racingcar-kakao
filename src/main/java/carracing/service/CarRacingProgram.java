package carracing.service;

import carracing.domain.Car;
import carracing.domain.Cars;
import carracing.utility.RandomNumber;
import carracing.view.CarInfoPrint;
import carracing.view.CarRacingInfoPrint;

import java.util.*;

public class CarRacingProgram {
    private Cars cars;
    private int totalMoveCount;

    private final String CAR_NAME_IDENTIFY_SYMBOL = ",";

    public CarRacingProgram(String carNames, int totalMoveCount){
        this.cars = insertCarNamesToCarList(carNames);
        this.totalMoveCount = totalMoveCount;
    }

    private Cars insertCarNamesToCarList(String carNames) {
        List<String> input = splitCarNames(carNames);

        return Cars.makeNewCars_text(input);
    }

    public void race(){
        CarRacingInfoPrint.printResultPhrase();
        for (int i = 0; i < totalMoveCount; i++) {
            playOneCycle();
        }

        CarRacingInfoPrint.printWinners(cars.selectRaceWinners());
    }

    private void playOneCycle(){
        cars.moveOrStopCars();
        cars.printCarsInfo();

        CarRacingInfoPrint.printBlankLine();
    }

    public List<String> splitCarNames(String carNames){
        return Arrays.asList(carNames.split(CAR_NAME_IDENTIFY_SYMBOL));
    }

    public Cars getCars(){
        return cars;
    }

}
