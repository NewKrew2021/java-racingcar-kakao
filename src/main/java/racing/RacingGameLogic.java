/*
 * File     : RacingGame.java
 * Date     : 2021. 01. 05
 */
package racing;

import java.util.ArrayList;
import java.util.List;

/*
 * Class    : RacingGameLogic
 * Version  : 1.1
 * author   : eli.nabro
 *
 * Racing game Logic class
 */
public class RacingGameLogic {

    private static final String SEPARATOR_OF_INPUT_CAR_NAME = ",";
    private static final int RANDOM_DIGIT = 10000;
    private static final String SEPARATOR_OF_WINNERS = ", ";
    private static final int STOP_VALUE = 3;

    private List<Car> cars;

    public RacingGameLogic(String carsName) {
        String[] nameArray = carsName.split(SEPARATOR_OF_INPUT_CAR_NAME);

        this.cars = new ArrayList<>();
        for (String name : nameArray) {
            this.cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Integer> getCarsPosition() {
        List<Integer> result = new ArrayList<>();

        for (Car car : this.cars) {
            result.add(car.getPosition());
        }

        return result;
    }

    public boolean checkPosition(int numbers) {
        int maxPosition = 0;

        for (Car car : this.cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition < numbers;
    }

    public void race() {

        for( Car car: this.cars) {
            car.move(decideGoOrStop());
        }
    }

    private boolean decideGoOrStop() {
        return this.makeRandomValue() > STOP_VALUE;
    }

    private int makeRandomValue() {
        return (int) (Math.random() * RANDOM_DIGIT % 10);
    }

    public String whoAreWinner(int maxProgressNumber) {
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
