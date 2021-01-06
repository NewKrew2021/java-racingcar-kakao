package carracing;

import java.util.*;

public class CarRacingProgram {
    private List<Car> cars;
    private int totalMoveCount;
    private int maxMoveDistance;
    private Scanner sc;
    private Random random;

    public CarRacingProgram() {
        cars = new ArrayList<>();
        sc = new Scanner(System.in);
        random = new Random();
    }

    public int getRandomNumber() {
        return random.nextInt(10);
    }

    private void insertRaceTryCount() {
        totalMoveCount = sc.nextInt();
    }

    public void race(){
        System.out.println(CarRacingProgramPhrase.CAR_LIST_INPUT_PHRASE);
        insertCarNamesToCars();

        System.out.println(CarRacingProgramPhrase.RACE_COUNT_PHRASE);
        insertRaceTryCount();

        System.out.println(CarRacingProgramPhrase.RESULT_PHRASE);
        for (int i = 0; i < totalMoveCount; i++) {
            playOneCycleAndPrintCarPosition();
        }

        printRaceWinners(findRaceWinners());
    }

    private void insertCarNamesToCars() throws RuntimeException {
        String[] names = sc.nextLine().split(",");
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void playOneCycleAndPrintCarPosition(){
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

    private List<String> findRaceWinners(){
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            compareMaxMoveDistanceToCarMoveCount(winners, car);
        }

        return winners;
    }

    private void compareMaxMoveDistanceToCarMoveCount(List<String> winners, Car car){
        if(car.getPosition() == maxMoveDistance){
            winners.add(car.getName());
        }
    }

    private void printRaceWinners(List<String> winners){
        StringBuilder winnerBuilder = new StringBuilder();

        for (int i = 0; i < winners.size()-1; i++) {
            winnerBuilder.append(winners.get(i)+", ");
        }
        winnerBuilder.append(winners.get(winners.size()-1));

        winnerBuilder.append(CarRacingProgramPhrase.WINNER_PHRASE);

        System.out.println(winnerBuilder.toString());
    }
}
