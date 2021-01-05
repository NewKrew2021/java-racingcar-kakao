package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private static final int LIMIT_NAME = 5;
    private static final int RANDOM_SCOPE = 10;
    private final List<Car> carList = new ArrayList<>();

    public void start(String text, int racingNum) {

        initCar(splitName(text));

        printResult();
        for (int i = 0; i < racingNum; i++) {
            racingGame();
            printResult();
        }
    }

    private void initCar(String[] names) {
        for (String name : names) {
            carList.add(new Car(name.trim()));
        }
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
            throw new RuntimeException();
        }
    }

    private int getMaxPosition() {
        int mx = 0;
        for (Car car : carList) {
            mx = Math.max(mx, car.getPosition());
        }
return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    private void addName(ArrayList<String> names, Car car) {
        int mx = getMaxPosition();

        if (mx == car.getPosition()) {
            names.add(car.getName());
        }

    }

    public ArrayList<String> getWinners() {
        ArrayList<String> names = new ArrayList<>();

        for (Car car : carList) {
            addName(names, car);
        }

        return names;
    }
}
