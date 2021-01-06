package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Random;

public class Racing {

    private Cars cars;
    private int tryNo;

    public void startRacing() {
        createCars(splitNames(enterCarNames()));

        this.tryNo = enterRound();
        System.out.println("실행 결과");

        IntStream.range(0, tryNo).forEach(i -> {
            race(cars);
            printCurrentCarStatus(cars);
            System.out.println();
        });
        printWinnerName();
    }

    private void race(Cars cars) {
        cars.moveAll();
    }

    public void createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.cars = new Cars(cars);
    }

    public List<String> splitNames(String str) {
        return new ArrayList<>(Arrays.asList(str.split(",")));
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
        System.out.print(String.join(",", cars.getWinnerName()));
        System.out.println("가 최종 우승했습니다.");
    }

    private void printCurrentCarStatus(Cars cars) {
        for (Car car : this.cars.getCars()) {
            System.out.print(car.getName() + " : ");
            printBars(car.getPosition());
        }
    }

    private void printBars(int number) {
        IntStream.range(0, number).forEach(i -> {
            System.out.print("-");
        });
        System.out.println();
    }
}
