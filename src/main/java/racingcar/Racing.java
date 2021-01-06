package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Random;

public class Racing {

    private List<Car> cars;

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

    private void createCars(List<String> names) {
        this.cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private List<String> splitNames(String str) {
        return new ArrayList<>(Arrays.asList(str.split(",")));
    }


    public boolean checkCarNames(List<String> names) {
        return names.stream().allMatch(name -> name.length() <= MAX_CAR_NAME_LENGTH);
    }

    private void racing() {
        for (Car car : this.cars) {
            car.move(getRandomInteger(0,9));
        }
    }

    public ArrayList<Integer> getFinalCarPositions(List<Car> cars) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }

    public ArrayList<String> getWinnerName(List<Car> cars) {
        int maxPosition = getMaxPosition(getFinalCarPositions(cars));

        return cars
                .stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toCollection(ArrayList::new));
    }


    public int getMaxPosition(List<Integer> positions) {
        return positions.stream()
                .mapToInt(x -> x)
                .max()
                .orElseThrow(java.util.NoSuchElementException::new);

    }

    public int getRandomInteger(int minimumValue, int maximumValue){
        Random random = new Random();
        return random.nextInt(maximumValue - minimumValue + 1) + minimumValue;
    }

    private String enterCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private int enterRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private void printWinnerName() {
        System.out.print(String.join(",", getWinnerName(this.cars)));
        System.out.println("가 최종 우승했습니다.");
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
}
