package domain;

import java.util.Arrays;
import java.util.Collections;
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
        validateCars(cars);
        this.cars = Collections.unmodifiableList(cars);
        this.finalRound = finalRound;
        this.rand = new Random();
        this.round = 0;
    }

    public RacingGame(String[] names, int finalRound) {
        this(Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList()), finalRound);
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
        List<Integer> positions = cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        int maxPosition = Collections.max(positions);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void validateCars(List<Car> cars){
        if(!isValidNumberOfCars(cars.size())){
            String message = String.format("자동차는 최소 %d대 이상 필요합니다.", MIN_NUM_CARS);
            throw new IllegalArgumentException(message);
        }

        for (Car car : cars) {
            validateCar(car);
        }
    }

    private void validateCar(Car car){
        if(!isValidCar(car)){
            String message = String.format("%s: 자동차의 이름은 최대 %d자 이내로 작성하세요.",car.getName(), MAX_LEN_NAME);
            throw new IllegalArgumentException(message);
        }
    }

    private boolean isValidCar(Car car){
        String name = car.getName();
        return !name.isEmpty() && name.length() <= MAX_LEN_NAME;
    }

    private boolean isValidNumberOfCars(int numCars){
        return numCars >= MIN_NUM_CARS;
    }
}
