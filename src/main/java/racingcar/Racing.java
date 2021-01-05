package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Racing {

    private List<Car> cars;
    private int round;

    private final int MAX_CAR_NAME_LENGTH = 5;

    public Racing() {
        this.cars = new ArrayList<>();
    }

    public void startRacing() {
        List<String> names = splitNames(enterCarNames());
        if (!isValidCarName(names)) {
            return;
        }
        registerCars(names);
        setRound(enterRound());

        System.out.println("실행 결과");
        race();
    }

    public void registerCars(List<String> names) {
        for (int i = 0; i < names.size(); i++) {
            cars.add(new Car(names.get(i)));
        }
    }

    private List<String> splitNames(String str) {
        return new ArrayList<>(Arrays.asList(str.split(",")));
    }

    private boolean isValidCarName(List<String> names) {
        boolean valid = true;
        for (String name: names) {
            valid = isValidNameLength(name.length());
        }
        return valid;
    }

    private boolean isValidNameLength(int len) {
        return len <= MAX_CAR_NAME_LENGTH;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void race() {
        printCurrentStatus();
        for (int i = 0; i < round; i++) {
            raceOneRepeat();
            printCurrentStatus();
        }
        printWinnerName();
    }

    private void printWinnerName() {
        System.out.print(String.join(",", winnerName()));
        System.out.println("가 최종 우승했습니다.");
    }

    private void printCurrentStatus() {
        for (Car car: this.cars) {
            System.out.printf("%-4s : ", car.getName());
            printStatusBar(car.getPosition());
        }
        System.out.println();
    }

    private void printStatusBar(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void raceOneRepeat() {
        for (Car car: this.cars) {
            car.move(createRandomNumber());
        }
    }

    private int createRandomNumber() {
        return (int) (Math.random() * 10);
    }

    private List<String> winnerName() {
        List<String> names = new ArrayList<>();
        for (Car car: whoWinner()) {
            names.add(car.getName());
        }
        return names;
    }

    private List<Car> whoWinner() {
        List<Car> winnerCars = new ArrayList<>();
        for(int carIndex: winnerCarIndex()) {
            winnerCars.add(this.cars.get(carIndex));
        }
        return winnerCars;
    }

    public List<Integer> winnerCarIndex() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < finalCarPositions().size(); i++) {
            result.add(checkFarthestCarIndex(i));
        }
        return result.stream()
                     .filter(idx -> idx >= 0)
                     .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Integer> finalCarPositions() {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < this.cars.size(); i++) {
            positions.add(this.cars.get(i).getPosition());
        }
        return positions;
    }

    private int checkFarthestCarIndex(int idx) {
        if (isSameBoth(max(finalCarPositions()), finalCarPositions().get(idx))) {
            return idx;
        }
        return -1;
    }

    private int max(List<Integer> positions) {
        int maxVal = positions.get(0);
        for (int element: positions) {
            maxVal = higherValueBoth(maxVal, element);
        }
        return maxVal;
    }

    private int higherValueBoth(int a, int b) {
        if (a < b) {
            return b;
        }
        return a;
    }

    private boolean isSameBoth(int a, int b) {
        return a == b;
    }

    private String enterCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int enterRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
