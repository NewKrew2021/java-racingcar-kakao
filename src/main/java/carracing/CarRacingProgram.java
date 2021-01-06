package carracing;

import java.util.*;

public class CarRacingProgram {
    private List<Car> carList;
    private int totalMoveCount;
    private int maxMoveDistance;
    private Scanner sc;
    private Random random;

    public CarRacingProgram() {
        carList = new ArrayList<>();
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
        insertCarNamesToCarList();

        System.out.println(CarRacingProgramPhrase.RACE_COUNT_PHRASE);
        insertRaceTryCount();

        System.out.println(CarRacingProgramPhrase.RESULT_PHRASE);
        for (int i = 0; i < totalMoveCount; i++) {
            playOneCycle();
        }

        printRaceWinners(findRaceWinner());
    }

    public void insertCarNamesToCarList() throws RuntimeException {
        String[] input = sc.nextLine().split(",");
        for (int i = 0; i < input.length; i++) {
            carList.add(new Car(input[i]));
        }
    }

    public void playOneCycle(){
        for (int i = 0; i < carList.size(); i++) {
            checkMovingCondition(i);
        }
        System.out.println();
    }

    public void checkMovingCondition(int index){
        if(getRandomNumber() >= 4){
            maxMoveDistance = Math.max(maxMoveDistance, carList.get(index).go());
        }
        System.out.println(carList.get(index).getCarInfoString());
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

    public void printRaceWinners(List<String> winnerList){
        StringBuilder winnerBuilder = new StringBuilder();

        for (int i = 0; i < winnerList.size()-1; i++) {
            winnerBuilder.append(winnerList.get(i)+", ");
        }
        winnerBuilder.append(winnerList.get(winnerList.size()-1));

        winnerBuilder.append(CarRacingProgramPhrase.WINNER_PHRASE);

        System.out.println(winnerBuilder.toString());
    }
}
