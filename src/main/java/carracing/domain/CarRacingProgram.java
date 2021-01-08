package carracing.domain;

import carracing.ui.ProgramInputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CarRacingProgram {

    private final int ABLE_MOVE_NUMBER = 4;

    private int maxMoveDistance;
    private Random random;
    private int roundCount;
    private List<Car> cars;

    public CarRacingProgram() {
        random = new Random();
    }

    public CarRacingProgram(String[] names, int roundCount) {
        this();
        cars = mapCarNamesToCars(names);
        this.roundCount = roundCount;
    }

    public int getRandomNumber() {
        return random.nextInt(10);
    }

    public List<String> race() {
        ProgramInputView.printResultPharse();

        for (int round = 0; round < roundCount; round++) {
            playOneCycleAndPrintCarPosition(cars);
        }

        return findRaceWinners(cars);
    }

    public List<Car> mapCarNamesToCars(String[] names) throws RuntimeException {
        List<Car> cars = new ArrayList<>();

        Arrays.stream(names).forEach(name -> cars.add(new Car(name)));

        return cars;
    }

    private void playOneCycleAndPrintCarPosition(List<Car> cars) {
        cars.stream().forEach(car -> {
            checkMovingConditionAfterMoveCar(car, getRandomNumber());
            ProgramInputView.printCarPosition(car);
        });

        ProgramInputView.printBlankLine();
    }

    private void checkMovingConditionAfterMoveCar(Car car, int randomNumber) {
        if (randomNumber >= ABLE_MOVE_NUMBER) {
            maxMoveDistance = updateMaxMoveDistance(car.go());
        }
    }

    private int updateMaxMoveDistance(int carPosition) {
        return Math.max(maxMoveDistance, carPosition);
    }

    private List<String> findRaceWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();

        cars.stream().forEach(car -> {
            if (car.isCarPositionEqualToIndex(maxMoveDistance)) {
                winners.add(car.getName());
            }
        });

        return winners;
    }
}
