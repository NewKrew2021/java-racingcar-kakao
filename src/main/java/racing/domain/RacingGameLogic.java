package racing.domain;

import racing.RandomValue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameLogic {

    private static final String SEPARATOR_OF_INPUT_CAR_NAME = ",";
    private static final String SEPARATOR_OF_WINNERS = ", ";
    private static final int STOP_VALUE = 3;

    private List<Car> cars;
    private int maxProgressNumber;

    public RacingGameLogic(String carsName, int numberOfTrials) {
        String[] nameArray = carsName.split(SEPARATOR_OF_INPUT_CAR_NAME);

        this.cars = new ArrayList<>();
        for (String name : nameArray) {
            this.cars.add(new Car(name));
        }

        this.maxProgressNumber = numberOfTrials;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Integer> getCarsPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

    public boolean checkPosition() {
        int maxPosition = 0;

        for (Car car : this.cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition < this.maxProgressNumber;
    }

    public void race() {
        List<Integer> randomValues = RandomValue.makeRandomValues(this.cars.size(), STOP_VALUE);

        for (int i = 0; i < this.cars.size(); i++) {
            this.decideGoOrStop(this.cars.get(i), randomValues.get(i));
        }
    }

    private void decideGoOrStop(Car car, int randomValue) {
        if( randomValue > STOP_VALUE ) {
            car.move();
        }
    }

    public String whoAreWinner() {
        StringBuilder winners = new StringBuilder();
        List<Integer> resultPosition = this.getCarsPosition();

        for (int i = 0; i < resultPosition.size(); i++) {
            winners.append(this.isWinner(i, maxProgressNumber));
        }

        return winners.toString();
    }

    private String isWinner(int index, int maxProgressNumber) {

        if(cars.get(index).getPosition() == maxProgressNumber) {
            return cars.get(index).getName() + SEPARATOR_OF_WINNERS;
        }

        return "";
    }

}
