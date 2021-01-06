package carracing;

import java.util.*;

public class CarRacingProgram {

    private int maxMoveDistance;
    private Scanner sc;
    private Random random;

    public CarRacingProgram() {
        sc = new Scanner(System.in);
        random = new Random();
    }

    public int getRandomNumber() {
        return random.nextInt(10);
    }

    private int insertRaceTryCount() {
        return sc.nextInt();
    }

    public void race(){
        List<Car> cars = new ArrayList<>();

        System.out.println(CarRacingProgramPhrase.CAR_LIST_INPUT_PHRASE);
        insertCarNamesToCars(cars);

        System.out.println(CarRacingProgramPhrase.RACE_COUNT_PHRASE);
        int round = insertRaceTryCount();

        System.out.println(CarRacingProgramPhrase.RESULT_PHRASE);
        for (int i = 0; i < round; i++) {
            playOneCycleAndPrintCarPosition(cars);
        }

        printRaceWinners(findRaceWinners(cars));
    }

    private void insertCarNamesToCars(List<Car> cars) throws RuntimeException {
        String[] names = sc.nextLine().split(",");
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void playOneCycleAndPrintCarPosition(List<Car> cars){
        for (Car car : cars) {
            checkMovingConditionAfterMoveCar(car);
            System.out.println(car.getCarInfoString());
        }
        System.out.println();
    }

    private void checkMovingConditionAfterMoveCar(Car car){
        if(getRandomNumber() >= 4){
            maxMoveDistance = updateMaxMoveDistance(car.go());
        }
    }

    private int updateMaxMoveDistance(int carPosition){
        return Math.max(maxMoveDistance, carPosition);
    }

    private List<String> findRaceWinners(List<Car> cars){
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            compareMaxMoveDistanceToCarMoveCount(winners, car);
        }

        return winners;
    }

    private void compareMaxMoveDistanceToCarMoveCount(List<String> winners, Car car){
        if(car.isPositionEqualMaxMoveDistance(maxMoveDistance)){
            winners.add(car.getName());
        }
    }

    private void printRaceWinners(List<String> winners){
        StringBuilder winnerBuilder = new StringBuilder();

        for (int i = 0; i < winners.size()-1; i++) {
            winnerBuilder.append(winners.get(i));
            winnerBuilder.append(", ");
        }
        winnerBuilder.append(winners.get(winners.size()-1));

        winnerBuilder.append(CarRacingProgramPhrase.WINNER_PHRASE);

        System.out.println(winnerBuilder.toString());
    }
}
