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

    public void insertRaceTryCount() {
        totalMoveCount = sc.nextInt();
    }

    public void race(){
        System.out.println(CarRacingProgramPhrase.CAR_LIST_INPUT_PHRASE);
        insertCarNamesToCars();

        System.out.println(CarRacingProgramPhrase.RACE_COUNT_PHRASE);
        insertRaceTryCount();

        System.out.println(CarRacingProgramPhrase.RESULT_PHRASE);
        for (int i = 0; i < totalMoveCount; i++) {
            playOneCycle();
        }

        printRaceWinners(findRaceWinners());
    }

    public void insertCarNamesToCars() throws RuntimeException {
        String[] input = sc.nextLine().split(",");
        for (int i = 0; i < input.length; i++) {
            cars.add(new Car(input[i]));
        }
    }

    public void playOneCycle(){
        for (int i = 0; i < cars.size(); i++) {
            checkMovingCondition(i);
        }
        System.out.println();
    }

    public void checkMovingCondition(int index){
        if(getRandomNumber() >= 4){
            maxMoveDistance = Math.max(maxMoveDistance, cars.get(index).go());
        }
        System.out.println(cars.get(index).getCarInfoString());
    }

    public List<String> findRaceWinners(){
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            compareMaxMoveDistanceToCarMoveCount(winners, i);
        }

        return winners;
    }

    public void compareMaxMoveDistanceToCarMoveCount(List<String> winners, int carIndex){
        if(cars.get(carIndex).getPosition() == maxMoveDistance){
            winners.add(cars.get(carIndex).getName());
        }
    }

    public void printRaceWinners(List<String> winners){
        StringBuilder winnerBuilder = new StringBuilder();

        for (int i = 0; i < winners.size()-1; i++) {
            winnerBuilder.append(winners.get(i)+", ");
        }
        winnerBuilder.append(winners.get(winners.size()-1));

        winnerBuilder.append(CarRacingProgramPhrase.WINNER_PHRASE);

        System.out.println(winnerBuilder.toString());
    }
}
