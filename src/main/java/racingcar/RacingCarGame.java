package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private static final int LIMIT_NAME = 5;
    private static final int RANDOM_SCOPE = 10;
    private List<Car> cars;
    private List<String> winners;

    public void start(String text, int racingNum) {

        initGame(splitName(text));
        printResult();

        for (int i = 0; i < racingNum; i++) {
            racingGame();
            printResult();
        }

        addWinners();
    }

    private void initGame(String[] names) {
        cars = new ArrayList<>();
        winners = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
    }

    protected int randomNum() {
        return (int) (Math.random() * RANDOM_SCOPE);
    }

    private void racingGame() {
        for (Car car : cars) {
            car.racing(randomNum());
        }
    }

    private void printResult() {
        for (Car car : cars) {
            System.out.println(car);
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
            throw new RuntimeException("이름이 5자를 초과하였습니다.");
        }
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    private void addName(Car car, int mx) {

        if (isMaxPosition(car, mx)) {
            winners.add(car.getName());
        }

    }

    private boolean isMaxPosition(Car car, int mx) {
        return mx == car.getPosition();
    }

    public List<String> getWinners() {
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }

    private void addWinners() {
        int mx = getMaxPosition();

        for (Car car : cars) {
            addName(car, mx);
        }
    }
}
