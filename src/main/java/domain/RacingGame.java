package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    public static final int MIN_NUM_CARS = 2;
    public static final int MAX_LEN_NAME = 5;
    static final int MAX_RAND_NUMBER = 9;
    static final int MIN_RAND_NUMBER = 0;
    static final int MOVE_THRESHOLD = 3;

    public final List<Car> cars;
    private final int finalRound;
    private final Random rand;
    private int round;

    public RacingGame(List<Car> cars, int finalRound) {
        this.cars = cars;
        this.finalRound = finalRound;
        this.rand = new Random();
        this.round = 0;
    }

    public RacingGame(String[] names, int finalRound) {
        this.cars = Arrays.stream(names)
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());
        this.finalRound = finalRound;
        this.rand = new Random();
        this.round = 0;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRandomNumber() {
        return rand.nextInt(MAX_RAND_NUMBER - MIN_RAND_NUMBER + 1) + MIN_RAND_NUMBER;
    }

    public void playRound() {
        for (Car car : cars) {
            int number = getRandomNumber();
            car.move(number);
        }
        ++round;
    }

    public boolean isEnd() {
        return round >= finalRound;
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
