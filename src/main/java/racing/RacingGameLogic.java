/*
 * File     : RacingGame.java
 * Date     : 2021. 01. 05
 */
package racing;

import java.util.ArrayList;
import java.util.List;

/*
 * Class    : RacingGameLogic
 * Version  : 1.0
 * author   : eli.nabro
 *
 * Racing game Logic class
 */
public class RacingGameLogic {

    private List<Car> cars;

    public void setCars(String s) {
        String[] nameArray = s.split(",");
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
        List<Integer> randomValues = this.makeRandomValues();
        for (int i = 0; i < this.cars.size(); i++) {
            cars.get(i).move(cars.get(i).decideGoOrStop(randomValues.get(i)));
        }
    }

    private List<Integer> makeRandomValues() {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < this.cars.size(); i++) {
            results.add((int) (Math.random() * 10000 % 10));
        }
        return results;
    }

    public String whoAreWinner(int maxProgressNumber) {
        String winners = "";
        List<Integer> resultPosition = this.getCarsPosition();
        for (int i = 0; i < resultPosition.size(); i++) {
            winners += this.isWinner(i, maxProgressNumber);
        }
        return winners;
    }

    private String isWinner(int index, int maxProgressNumber) {
        if(cars.get(index).getPosition() == maxProgressNumber) {
            return cars.get(index).getName() + ", ";
        }
        return "";
    }

}
