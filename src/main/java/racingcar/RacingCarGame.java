package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCarGame {
    private static final int LIMIT_NAME = 5;
    private static final int RANDOM_SCOPE = 10;
    private final List<Car> carList = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public void start() {
        scanName();
        int racingNum = scanRacingNum();

        printResult();
        for (int i = 0; i < racingNum; i++) {
            racingGame();
            printResult();
        }
    }

    private void scanName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String text = sc.nextLine();
        String[] names = splitName(text);
        initCar(names);
    }

    private void initCar(String[] names) {
        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    private int scanRacingNum() {
        System.out.println("시도할 회수는 몇회인가요?");

        return sc.nextInt();
    }

    private int randomNum() {
        return (int) (Math.random() * RANDOM_SCOPE);
    }

    private void racingGame() {
        for (Car car : carList) {
            car.racing(randomNum());
        }
    }

    private void printResult() {
        for (Car car : carList) {
            car.printResult();
        }
        System.out.println();
    }

    public String[] splitName(String text) {
        return checkName(text.split(","));
    }

    private String[] checkName(String[] names) {
        for (String name : names) {
            checkOverflow(name);
        }
        return names;
    }

    private void checkOverflow(String name) {
        if (name.length() > LIMIT_NAME) {
            throw new RuntimeException();
        }
    }
}
