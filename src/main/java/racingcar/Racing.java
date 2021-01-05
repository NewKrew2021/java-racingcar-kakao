package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {

    public List<Car> cars;

    private final int MAX_CAR_NAME_LENGTH = 5;

    public void startRacing() {

        List<String> names;
        do{
            names = splitNames(enterCarNames());
        }while(!checkCarNames(names));

        createCars(names);

        int round = enterRound();

        System.out.println("실행 결과");
        IntStream.range(0, round).forEach(i -> {
            racing();
            printCurrentCarStatus();
            System.out.println();
        });

        printWinnerName();
    }

    private void printWinnerName() {
        System.out.print(String.join(",", getWinnerName()));
        System.out.println("가 최종 우승했습니다.");
    }

    private void createCars(List<String> names) {
        this.cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private String enterCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private List<String> splitNames(String str) {
        return new ArrayList<>(Arrays.asList(str.split(",")));
    }

    //리펙토링 필요(들여쓰기 문)
    private boolean checkCarNames(List<String> names) {
        for(String name: names){
            if (name.length() > MAX_CAR_NAME_LENGTH) {
                return false;
            }
        }
        return true;
    }

    private int enterRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private void racing(){
        for (Car car : this.cars) {
            car.move(createNumber());
        }
    }

    private void printCurrentCarStatus() {
        for(Car car: this.cars){
            System.out.print(car.getName()+" : ");
            printBars(car.getPosition());
        }
    }
    private void printBars(int number){
        IntStream.range(0, number).forEach(i ->{
            System.out.print("-");
        });
        System.out.println();
    }

    public ArrayList<Integer> getFinalCarPositions() {
        ArrayList<Integer> positions = new ArrayList<>();
        for (Car car : this.cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }

    public ArrayList<Car> getWinner() {
        int maxPosition = getMaxPosition(getFinalCarPositions());

        ArrayList<Car> winnerCars = new ArrayList<>();
        for(int carIndex: getWinnerCarsIndex(maxPosition, getFinalCarPositions())){
            winnerCars.add(this.cars.get(carIndex));
        }
        return winnerCars;
    }

    private ArrayList<String> getWinnerName(){
        ArrayList<String> names = new ArrayList<>();
        for(Car car: getWinner()){
            names.add(car.getName());
        }
        return names;
    }


    private ArrayList<Integer> getWinnerCarsIndex(int maxPosition, List<Integer> currentCarPositions) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < currentCarPositions.size(); i++) {
            result.add(checkFarthestCarIndex(maxPosition, currentCarPositions.get(i), i));
        }
        return result.stream().filter(a -> a >= 0).collect(Collectors.toCollection(ArrayList::new));
    }

    private int checkFarthestCarIndex(int maxPosition, int currentCarPosition,int index){
        if(maxPosition == currentCarPosition){
            return index;
        }
        return -1;
    }

    private int getMaxPosition(List<Integer> positions) {
        int maxVal = positions.get(0);
        for (int element : positions) {
            maxVal = Math.max(maxVal, element);
        }
        return maxVal;
    }

    private int createNumber() {
        return (int) (Math.random() * 10);
    }
}
