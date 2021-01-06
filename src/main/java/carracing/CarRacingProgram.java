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
        String[] input = sc.nextLine().split(",");
        for (int i = 0; i < input.length; i++) {
            cars.add(new Car(input[i]));
        }
    }

    private void playOneCycleAndPrintCarPosition(){
        for (int i = 0; i < cars.size(); i++) {
            checkMovingConditionAfterMoveCar(i);
            System.out.println(cars.get(i).getCarInfoString());
        }
        System.out.println();
    }

    private void checkMovingConditionAfterMoveCar(int index){
        if(getRandomNumber() >= 4){
            maxMoveDistance = updateMaxMoveDistance(cars.get(index).go());
        }
    }

    private int updateMaxMoveDistance(int carPosition){
        return Math.max(maxMoveDistance, carPosition);
    }

    private List<String> findRaceWinners(){
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            compareMaxMoveDistanceToCarMoveCount(winners, i);
        }

        return winners;
    }

    private void compareMaxMoveDistanceToCarMoveCount(List<String> winners, int carIndex){
        if(cars.get(carIndex).getPosition() == maxMoveDistance){
            winners.add(cars.get(carIndex).getName());
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
