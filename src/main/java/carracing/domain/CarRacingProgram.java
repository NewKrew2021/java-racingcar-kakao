package carracing.domain;

import carracing.ui.CarRacingProgramUI;

import java.util.*;

public class CarRacingProgram {

    private int maxMoveDistance;
    private Scanner scanner;
    private Random random;

    private final int ABLE_MOVE_NUMBER = 4;
    private final String NAMES_DELIMETER = ",";

    public CarRacingProgram() {
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public int getRandomNumber() {
        return random.nextInt(10);
    }

    private int insertRound() {
        return scanner.nextInt();
    }

    public void race(){
        CarRacingProgramUI.printCarInputNamesPharse();
        List<Car> cars = mapCarNamesToCars(insertCarNames());

        CarRacingProgramUI.printRaceCountPhrase();
        int round = insertRound();

        CarRacingProgramUI.printResultPharse();
        for (int i = 0; i < round; i++) {
            playOneCycleAndPrintCarPosition(cars);
        }

        CarRacingProgramUI.printWinnerPharse(findRaceWinners(cars));
    }

    private String[] insertCarNames(){
        return scanner.nextLine().split(NAMES_DELIMETER);
    }

    private List<Car> mapCarNamesToCars(String[] names) throws RuntimeException {
        List<Car> cars = new ArrayList<>();

        Arrays.stream(names).forEach(name -> cars.add(new Car(name)));

        return cars;
    }

    private void playOneCycleAndPrintCarPosition(List<Car> cars){
        cars.stream().forEach(car -> {
            checkMovingConditionAfterMoveCar(car, getRandomNumber());
            CarRacingProgramUI.printCarPosition(car);
        });

        CarRacingProgramUI.printBlankLine();
    }

    private void checkMovingConditionAfterMoveCar(Car car,int randomNumber){
        if(randomNumber >= ABLE_MOVE_NUMBER){
            maxMoveDistance = updateMaxMoveDistance(car.go());
        }
    }

    private int updateMaxMoveDistance(int carPosition){
        return Math.max(maxMoveDistance, carPosition);
    }

    private List<String> findRaceWinners(List<Car> cars){
        List<String> winners = new ArrayList<>();

        cars.stream().forEach(car -> compareMaxMoveDistanceToCarMoveCount(winners, car));

        return winners;
    }

    private void compareMaxMoveDistanceToCarMoveCount(List<String> winners, Car car){
        if(car.isPositionEqualMaxMoveDistance(maxMoveDistance)){
            winners.add(car.getName());
        }
    }

}
